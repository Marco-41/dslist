package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service //IRÁ REGISTRAR ESTA CLASSE COMO UM COMPONENTE DO SISTEMA.
public class GameListService {

	//INJETANDO UM GameRepository AQUI NO GameService.
	@Autowired
	private GameListRepository gameListRepository;
	
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
}
