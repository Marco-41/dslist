package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //IRÁ REGISTRAR ESTA CLASSE COMO UM COMPONENTE DO SISTEMA.
public class GameListService {

	//INJETANDO UM GameListRepository AQUI NO GameListService.
	@Autowired
	private GameListRepository gameListRepository;
	
	//INJETANDO UM GameRepository AQUI NO GameListService.
	@Autowired
	private GameRepository gameRepository;
	
	//CRIAÇÃO DO MÉTODO PARA DEVOLVER UMA LISTA DO TIPO GameMinDTO.
	@Transactional(readOnly = true) //GARANTINDO QUE O BD NÃO IRÁ PARAR ESPERANDO UMA ESCRITA.
	public List<GameListDTO> findAll(){ //IRÁ BUSCAR TODOS OS GAMES.
		
		List<GameList> result = gameListRepository.findAll(); //VARIÁVEL result ARMAZENARÁ TODOS OS RESULTADOS DO gameRepository.
		List<GameListDTO> listDto = result.stream().map(x -> new GameListDTO(x)).toList(); /*O stream PERMITE FAZER OPERAÇÕES
		COM SEQUÊNCIAS DE DADOS, 
		O map TRANSFORMA OBJETOS DE UMA COISA PARA OUTRA (TODOS OBJETOS "x" ORIGINAL QUE ERAM GAMES SERÃO TRANFORMADOS EM 
		new GameMinDTO PASSANDO O "x" COMO ARGUMENTO). E PARA VOLTAR O STREAM PARA UMA LISTA USA-SE O ".toList().*/
		return listDto;
	}
	
	//CRIAÇÃO DO MÉTODO QUE IRÁ REORGANIZAR A PILHA DE JOGOS.
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId); //VARIÁVEL list ARMAZENARÁ TODOS OS RESULTADOS DO gameRepository.
		
		GameMinProjection obj = list.remove(sourceIndex); //obj RECEBE O RESULTADO DA REMOÇÃO.
		
		list.add(destinationIndex, obj); //IRÁ ADICIONAR O obj NA POSIÇÃO destinationIndex.
		
		//CONDICIONAL TERNÁRIA PARA ENCONTRAR O VALOR MÍNIMO ENTRE O sourceIndex E O destinationIndex.
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		
		//CONDICIONAL TERNÁRIA PARA ENCONTRAR O VALOR MÁXIMO ENTRE O sourceIndex E O destinationIndex.
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++) {
			
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i); /*IRÁ ATUALIZAR A LISTA
			ACESSANDO O id DA LISTA, O id DO GAME E INDEXANDO A NOVA POSIÇÃO DO GAME.*/
		}
	}
}
