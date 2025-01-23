package com.gpolicene.dslist.controllers;

import com.gpolicene.dslist.dto.GameMinDTO;
import com.gpolicene.dslist.dto.ListDTO;
import com.gpolicene.dslist.dto.ReplacementDTO;
import com.gpolicene.dslist.services.GameService;
import com.gpolicene.dslist.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    private ListService listService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<ListDTO> findAll(){
        return listService.findAll();
    }


    // Estamos colocando a busca de jogos na ListController porque o endpoint primeiramente acessa o service de Lists.
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        listService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
