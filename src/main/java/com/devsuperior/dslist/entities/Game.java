package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //IRÁ CONFIGURAR ESTA CLASSE PARA SER EQUIVALENTE A UMA TABELA NO BD.
@Table(name = "tb_game") //IRÁ CUSTOMIZAR O NOME DA TABELA NO BD.
public class Game {

	//ATRIBUTOS DESTA CLASSE.
	
	@Id //PARA CONFIGURAR O id COMO CHAVE PRIMÁRIA NO BD.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PARA QUE O id SEJA AUTOINCREMENTADO PELO BD.
	private Long id; 
	
	private String title;
	
	@Column(name = "game_year") //PARA DIFERENCIAR O NOME DO ATRIBUTO year (year É UMA PALAVRA RESERVADA NO SQL).
	private Integer year;
	
	private String genre;
	private String platform;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	private Double score;
	
	//CRIAÇÃO DO CONSTRUTOR SEM ARGUMENTOS.
	public Game() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS.
	public Game(Long id, String title, Integer year, String genre, String platform, String imgUrl,
			String shortDescription, String longDescription, Double score) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platform = platform;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.score = score;
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	//CRIAÇÃO DO MÉTODO HASH AND EQUALS PARA COMPARAR OS GAMES.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
