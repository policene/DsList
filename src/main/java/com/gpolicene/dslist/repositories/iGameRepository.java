package com.gpolicene.dslist.repositories;

import com.gpolicene.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iGameRepository extends JpaRepository<Game, Long> {
    // Os dois tipos no <Game, Long> são referentes à classe Game, e à classe do nosso id do Game;
}
