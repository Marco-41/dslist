package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

//ESTA CLASSE SERÁ A CAMADA RESPONSÁVEL POR ACESSAR/CONSULTAR OS DADOS.
public interface GameListRepository extends JpaRepository<GameList, Long>{

	//CONSULTA SQL PARA ATUALIZAR AS POSIÇÕES NO BD.
	@Modifying
	@Query(nativeQuery = true, 
		value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
