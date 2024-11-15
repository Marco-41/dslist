package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

/*ESTA CLASSE SERVE PARA REPRESENTAR DE MANEIRA RESUMIDA SOMENTE OS CONTEÚDOS DOS ATRIBUTOS DA CLASSE GAME
 * QUE SERÃO VISÍVEIS NA APLICAÇÃO*/
public class GameMinDTO {

	//DECLARAÇÃO DOS ATRIBUTOS DESTA CLASSE.
	private Long id; 
	private String title;
	private Integer year;	
	private String imgUrl;
	private String shortDescription;
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public GameMinDTO() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR QUE RECEBERÁ A ENTIDADE GAME.
	public GameMinDTO(Game entity) { //INSTANCIANDO UM GameMinDTO A PARTIR DE UM OBJETO GAME.	
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	//CRIAÇÃO DO CONSTRUTOR QUE RECEBERÁ A ENTIDADE GameMinProjecion.
	public GameMinDTO(GameMinProjection projection) { //INSTANCIANDO UM GameMinDTO A PARTIR DE UM OBJETO GameMinProjecion.	
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}

	//CRIAÇÃO DOS GETTERS.
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	
}
