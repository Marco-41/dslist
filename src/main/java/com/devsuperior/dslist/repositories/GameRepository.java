package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

//ESTA CLASSE SERÁ A CAMADA RESPONSÁVEL POR ACESSAR/CONSULTAR OS DADOS.
public interface GameRepository extends JpaRepository<Game, Long>{

}
