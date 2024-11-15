package com.devsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {

	//ATRIBUTOS DESTA CLASSE.
	private Long id;
	private String name;
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO
	public GameListDTO() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS QUE IRÁ RECEBER A ENTIDADE GameList COMO PARÂMETRO.
	public GameListDTO(GameList entity) {

		//COPIANDO OS ATRIBUOS DA CLASSE GameList PARA ESTA CLASSE GameListDTO.
		BeanUtils.copyProperties(entity, this); /*BeanUtils CLASSE UTILITÁRIA QUE IMPLEMENTA TODOS OS ATRIBUTOS DESTA CLASSE,
		(entity É A ORIGEM, this É A PRÓPRIA CLASSE).*/
	}
	
	//PARA FUNCIONAR ESTA CÓPIA DO BeanUtils DENTRO DESTA CLASSE DTO É NECESSÁRIO OS GETTERS E SETTERS.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
