package com.devsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.Game;

public class GameDTO {

	//DECLARAÇÃO DOS ATRIBUTOS DESTA CLASSE.
	
	private Long id; 
	private String title;
	private Double score;
	private Integer year;
	private String genre;
	private String platforms;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;

	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public GameDTO() {
		
	}
	
	//CRIAÇÃO DO CONSTRUTOR QUE RECEBERÁ A ENTIDADE GAME.
	public GameDTO(Game entity) { //INSTANCIANDO UM GameDTO A PARTIR DE UM OBJETO GAME.
		
		//IMPLEMENTANDO OS ATRIBUTOS DESTA CLASSE.
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
		
}
