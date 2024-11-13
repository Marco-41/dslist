package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //IRÁ REGISTRAR ESTA CLASSE COMO UM COMPONENTE DO SISTEMA.
public class GameService {

	//INJETANDO UM GameRepository AQUI NO GameService.
	@Autowired
	private GameRepository gameRepository;
	
	//CRIAÇÃO DO MÉTODO PARA DEVOLVER UMA LISTA DO TIPO GameMinDTO.
	public List<GameMinDTO> findAll(){ //IRÁ BUSCAR TODOS OS GAMES.
		
		List<Game> result = gameRepository.findAll(); //VARIÁVEL result ARMAZENARÁ TODOS OS RESULTADOS DO gameRepository.
		List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList(); /*O stream PERMITE FAZER OPERAÇÕES COM SEQUÊNCIAS DE DADOS, O map
		TRANSFORMA OBJETOS DE UMA COISA PARA OUTRA (TODOS OBJETOS "x" ORIGINAL QUE ERAM GAMES SERÃO TRANFORMADOS EM 
		new GameMinDTO PASSANDO O "x" COMO ARGUMENTO). E PARA VOLTAR O STREAM PARA UMA LISTA USA-SE O ".toList().*/
		return listDto;
	}
}
