package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //IRÁ CONFIGURAR ESTA CLASSE PARA SER EQUIVALENTE A UMA TABELA NO BD.
@Table(name = "tb_game_list") //IRÁ CUSTOMIZAR O NOME DA TABELA NO BD.
public class GameList {
	
	//ATRIBUTOS DESTA CLASSE.
	
	@Id //PARA CONFIGURAR O id COMO CHAVE PRIMÁRIA NO BD.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PARA QUE O id SEJA AUTOINCREMENTADO PELO BD.
	private Long id;
	private String name;
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public GameList() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS.
	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
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

	//CRIAÇÃO DO MÉTODO hashCode() and equals(), PARA COMPARAR UM GameList COM O OUTRO PELO id.
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
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}

}
