package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.sport.Sport;
import com.bettoven.BetovenProject.services.sport.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("sport")
public class SportAPI {
    @Autowired
    private SportService sportService;

    @GetMapping(value = "svi")
    public ResponseEntity<List<Sport>> sviSportovi(){
        return new ResponseEntity(sportService.sviSportovi(), HttpStatus.OK);
    }

    @PostMapping(value = "pretraga/{naziv}")
    public ResponseEntity<Sport> pretragaSporta(@PathVariable(name = "naziv") String naziv){
        return new ResponseEntity(sportService.pretraziSport(naziv),HttpStatus.OK);
    }

    @PostMapping(value = "ubaci",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sport> ubaciNovSport(@RequestBody Sport sport){
        return new ResponseEntity(sportService.ubaciSport(sport),HttpStatus.OK);
    }
}
