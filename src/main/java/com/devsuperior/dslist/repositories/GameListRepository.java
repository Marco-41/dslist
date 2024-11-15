package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

//ESTA CLASSE SERÁ A CAMADA RESPONSÁVEL POR ACESSAR/CONSULTAR OS DADOS.
public interface GameListRepository extends JpaRepository<GameList, Long>{

}
