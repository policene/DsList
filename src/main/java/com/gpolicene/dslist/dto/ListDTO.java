package com.gpolicene.dslist.dto;

import com.gpolicene.dslist.entities.GameList;

public class ListDTO {

    private Long id;
    private String name;


    public ListDTO () {
    }

    public ListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
