package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.statistika.StatistikaKvoteView;
import com.bettoven.BetovenProject.services.statistika.StatistikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistika")
public class StatistikaAPI {
    @Autowired
    private StatistikaService service;

    @GetMapping(value = "{mecID}")
    public ResponseEntity<StatistikaKvoteView> statistikaMeca(@PathVariable(name = "mecID") Integer id){
        return new ResponseEntity(service.pregledMeca(id), HttpStatus.OK);
    }
}
