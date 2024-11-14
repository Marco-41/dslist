package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*ESTA CLASSE AUXILIAR REPRESENTARÁ A CHAVE PRIMÁRIA DA CLASSE Game E A CHAVE PRIMÁRIA DA CLASSE GameList.*/

@Embeddable
public class BelongingPk {
	

	@ManyToOne //ANOTAÇÃO MUITOS PRA UM.
	@JoinColumn(name = "game_id") //CONFIGURANDO O NOME DA CHAVE ESTRANGEIRA.
	private Game game; //INSTANCIANDO UM GAME PARA CRIAR UMA REFERÊNCIA A ESTA CLASSE.
	
	@ManyToOne //ANOTAÇÃO MUITOS PRA UM.
	@JoinColumn(name = "gameList_id") //CONFIGURANDO O NOME DA CHAVE ESTRANGEIRA.
	private GameList gameList; //INSTANCIANDO UM GameList PARA CRIAR UMA REFERÊNCIA A ESTA CLASSE.
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public BelongingPk() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS.
	public BelongingPk(Game game, GameList gameList) {
		this.game = game;
		this.gameList = gameList;
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getGameList() {
		return gameList;
	}

	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, gameList);
	}

	/*CRIAÇÃO DO MÉTODO hashCode() and equals(), PARA COMPARAR UM Game COM UM GameList PELO id 
	 (por esta classe ser de chave múltipla).*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPk other = (BelongingPk) obj;
		return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
	}
	
	
	
	
}
