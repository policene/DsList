package com.gpolicene.dslist.services;

import com.gpolicene.dslist.dto.GameMinDTO;
import com.gpolicene.dslist.entities.Game;
import com.gpolicene.dslist.repositories.iGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private iGameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream()
                .map(GameMinDTO::new)
                .toList(); // Está retornando um DTO.
    }

}
