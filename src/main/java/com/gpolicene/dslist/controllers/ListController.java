package com.gpolicene.dslist.controllers;

import com.gpolicene.dslist.dto.GameMinDTO;
import com.gpolicene.dslist.dto.ListDTO;
import com.gpolicene.dslist.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping
    public List<ListDTO> findAll(){
        return listService.findAll();
    }

}
