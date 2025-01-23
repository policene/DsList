package com.gpolicene.dslist.services;

import com.gpolicene.dslist.dto.ListDTO;
import com.gpolicene.dslist.entities.GameList;
import com.gpolicene.dslist.projections.GameMinProjection;
import com.gpolicene.dslist.repositories.iGameRepository;
import com.gpolicene.dslist.repositories.iListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private iListRepository listRepository;
    @Autowired
    private iGameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<ListDTO> findAll(){
        List<GameList> result = listRepository.findAll();
        return result.stream()
                .map(ListDTO::new)
                .toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i <= max; i ++){
            listRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }


}
