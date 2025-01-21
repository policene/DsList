package com.gpolicene.dslist.repositories;

import com.gpolicene.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iListRepository extends JpaRepository<GameList, Long> {

}
