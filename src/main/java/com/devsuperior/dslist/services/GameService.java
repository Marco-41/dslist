package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //IRÁ REGISTRAR ESTA CLASSE COMO UM COMPONENTE DO SISTEMA.
public class GameService {

	//INJETANDO UM GameRepository AQUI NO GameService.
	@Autowired
	private GameRepository gameRepository;
	
	//CRIANDO UM MÉTODO PARA REALIZAR A BUSCA PELO id.
	@Transactional(readOnly = true) //GARANTINDO QUE O BD NÃO IRÁ PARAR ESPERANDO UMA ESCRITA.
	public GameDTO findById(Long id) { //ESPECIFICANDO O id NO ARGUMENTO PARA O MÉTODO PODER ENCONTRÁ-LO.
		
		//BUSCANDO O BD NO Repository E RETORNANDO OS id's.
		Game result = gameRepository.findById(id).get();
		
		//CONVERTENDO O OBJETO GAME PARA UM GameDTO.
		GameDTO dto = new GameDTO(result);
		
		//RETORNANDO O RESULTADO DA CONVERSÃO.
		return dto;
	}
	
	//CRIAÇÃO DO MÉTODO PARA DEVOLVER UMA LISTA DO TIPO GameMinDTO.
	@Transactional(readOnly = true) //GARANTINDO QUE O BD NÃO IRÁ PARAR ESPERANDO UMA ESCRITA.
	public List<GameMinDTO> findAll(){ //IRÁ BUSCAR TODOS OS GAMES.
		
		List<Game> result = gameRepository.findAll(); //VARIÁVEL result ARMAZENARÁ TODOS OS RESULTADOS DO gameRepository.
		List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList(); /*O stream PERMITE FAZER OPERAÇÕES
		COM SEQUÊNCIAS DE DADOS, 
		O map TRANSFORMA OBJETOS DE UMA COISA PARA OUTRA (TODOS OBJETOS "x" ORIGINAL QUE ERAM GAMES SERÃO TRANFORMADOS EM 
		new GameMinDTO PASSANDO O "x" COMO ARGUMENTO). E PARA VOLTAR O STREAM PARA UMA LISTA USA-SE O ".toList().*/
		return listDto;
	}
}
