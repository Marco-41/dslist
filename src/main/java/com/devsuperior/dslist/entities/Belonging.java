package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity //IRÁ CONFIGURAR ESTA CLASSE PARA SER EQUIVALENTE A UMA TABELA NO BD.
@Table(name = "tb_belonging") //IRÁ CUSTOMIZAR O NOME DA TABELA NO BD.
public class Belonging {

	//ATRIBUTOS DESTA CLASSE.
	private Integer position;
	
	@EmbeddedId
	private BelongingPk id = new BelongingPk(); //INSTANCIANDO UM BelongingPk PARA CRIAR UMA REFERÊNCIA A ESTA CLASSE.
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public Belonging() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS.
	public Belonging(Integer position, Game game, GameList gameList) {
		this.position = position;
		id.setGame(game);
		id.setGameList(gameList);
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public BelongingPk getId() {
		return id;
	}

	public void setId(BelongingPk id) {
		this.id = id;
	}

	//CRIAÇÃO DO MÉTODO hashCode() AND equals() PARA COMPARAR OS ID's
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
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
