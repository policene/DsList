package com.gpolicene.dslist.services;

import com.gpolicene.dslist.dto.GameDTO;
import com.gpolicene.dslist.dto.GameMinDTO;
import com.gpolicene.dslist.entities.Game;
import com.gpolicene.dslist.repositories.iGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private iGameRepository gameRepository;

    @Transactional(readOnly = true) // Assegurando que não vai fazer nenhum operação de escrita, tornando mais rápida a busca.
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream()
                .map(GameMinDTO::new)
                .toList(); // Está retornando um DTO.
    }

    @Transactional(readOnly = true)
    public GameDTO findByID(Long id){
        Game result = gameRepository.findById(id).get(); // O .get() serve porque o findById retorna um Optional. O correto seria fazer um tratamento de possível busca nula.
        return new GameDTO(result);
    }

}
