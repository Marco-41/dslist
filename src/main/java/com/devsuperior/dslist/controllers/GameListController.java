package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;

/*ESTA CLASSE SERÁ A PORTA DE ENTRADA PARA O BACKEND (É A MAÇANETA DA PORTA)*/

@RestController //IRÁ CONFIGURAR ESTA CLASSE PARA SER UM CONTROLADOR.
@RequestMapping(value = "/lists")//PARA MAPEAR O RECURSO.
public class GameListController {
	
	//INJETANDO UM GameService AQUI NO GameController.
	@Autowired
	public GameListService gameListService;


	//CRIAÇÃO DO MÉTODO QUE RETORNARÁ UMA LISTA DOS GAMES.
	@GetMapping //CONFIGURANDO O MÉTODO PARA RETORNAR A REQUISIÇÃO HTTP COMO GET.
	public List<GameListDTO> findAll(){

		List<GameListDTO> result = gameListService.findAll(); //VARIÁVEL result ARMAZENARÁ TODOS OS RESULTADOS DO GameMinDTO.
		return result;
	}
}
