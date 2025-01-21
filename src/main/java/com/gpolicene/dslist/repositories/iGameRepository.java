package com.gpolicene.dslist.repositories;

import com.gpolicene.dslist.entities.Game;
import com.gpolicene.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface iGameRepository extends JpaRepository<Game, Long> {
    // Os dois tipos no <Game, Long> são referentes à classe Game, e à classe do nosso id do Game;

    // O repository é o responsável por acessar o banco de dados, então tudo referente à consultas
    // deve estar por aqui, como no caso dessa query. Mas como estamos utilizando SQL, e não JPQL,
    // precisamos colocar o 'nativeQuery == true', e também precisamos criar uma Projection para a
    // query.

    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")

    List<GameMinProjection> searchByList(Long listId);
}
