package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.bettoven.BetovenProject.services.tim.TimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tim")
public class TimAPI {
    @Autowired
    private TimService timService;

    @GetMapping(value = "svi")
    public ResponseEntity<List<Tim>> sviTimovi(){
        return new ResponseEntity(timService.sviTimovi(), HttpStatus.OK);
    }

    @GetMapping(value = "pretraga/{naziv}")
    public ResponseEntity<List<Tim>> pretragaTimova(@PathVariable(name = "naziv") String nazivTima){
        return new ResponseEntity(timService.pretragaTimova(nazivTima),HttpStatus.OK);
    }

    @GetMapping(value = "ucesce/{naziv}")
    public ResponseEntity<List<Liga>> ucesceTima(@PathVariable(name = "naziv") String nazivTima){
        return new ResponseEntity(timService.ucesceTima(nazivTima),HttpStatus.OK);
    }

    @PostMapping(value = "ubaci",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tim> novTim(@RequestBody Tim tim){
        return new ResponseEntity(timService.ubaciTim(tim),HttpStatus.OK);
    }
}
