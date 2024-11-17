package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

/*ESTA CLASSE SERÁ A PORTA DE ENTRADA PARA O BACKEND (É A MAÇANETA DA PORTA)*/

@RestController //IRÁ CONFIGURAR ESTA CLASSE PARA SER UM CONTROLADOR.
@RequestMapping(value = "/lists")//PARA MAPEAR O RECURSO.
public class GameListController {
	
	//INJETANDO UM GameListService AQUI NO GameListController.
	@Autowired
	private GameListService gameListService;
	
	//INJETANDO UM GameService AQUI NO GameListController.
	@Autowired
	private GameService gameService;

	//CRIAÇÃO DO MÉTODO QUE RETORNARÁ UMA LISTA DOS GAMES.
	@GetMapping //CONFIGURANDO O MÉTODO PARA RETORNAR A REQUISIÇÃO HTTP COMO GET.
	public List<GameListDTO> findAll(){

		List<GameListDTO> result = gameListService.findAll(); //VARIÁVEL result ARMAZENARÁ TODOS OS RESULTADOS DO GameMinDTO.
		return result;
	}
	
	//CRIAÇÃO DO MÉTODO QUE RETORNARÁ UMA LISTA DOS GAMES.
	@GetMapping(value = "/{listId}/games") //CONFIGURANDO O MÉTODO PARA RETORNAR A REQUISIÇÃO HTTP COMO GET.
	public List<GameMinDTO> findByList(@PathVariable Long listId){ //ANOTAÇÃO PARA RECEBER O id QUE SERÁ PASSADO NA REQUISIÇÃO.

		List<GameMinDTO> result = gameService.findByList(listId); //VARIÁVEL result ARMAZENARÁ TODOS OS RESULTADOS DO GameMinDTO.
		return result;
	}
	
	//CRIAÇÃO DO MÉTODO QUE RETORNARÁ UMA LISTA DOS GAMES.
	@PostMapping(value = "/{listId}/replacement") //CONFIGURANDO O MÉTODO PARA RETORNAR A REQUISIÇÃO HTTP COMO GET.
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){ /*ANOTAÇÃO PARA RECEBER O id QUE SERÁ PASSADO NA REQUISIÇÃO
	JUNTAMENTE COM O CORPO DA API.*/

		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex()); /*CHAMADA DO SERVICE PARA IR LÁ NO
		BD E ATUALIZÁ-LO.*/
	}
}
