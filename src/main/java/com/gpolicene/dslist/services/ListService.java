package com.gpolicene.dslist.services;

import com.gpolicene.dslist.dto.ListDTO;
import com.gpolicene.dslist.entities.GameList;
import com.gpolicene.dslist.repositories.iListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private iListRepository listRepository;

    @Transactional(readOnly = true)
    public List<ListDTO> findAll(){
        List<GameList> result = listRepository.findAll();
        return result.stream()
                .map(ListDTO::new)
                .toList();
    }


}
