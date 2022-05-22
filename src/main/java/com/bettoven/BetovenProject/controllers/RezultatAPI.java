package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.rezultat.Rezultat;
import com.bettoven.BetovenProject.services.rezultat.RezultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rezultat")
public class RezultatAPI {
    @Autowired
    private RezultatService rezultatService;

    @GetMapping(value = "svi")
    public ResponseEntity<List<Rezultat>> sviRezultatti(){
        return new ResponseEntity(rezultatService.sviRezultati(), HttpStatus.OK);
    }

    @PostMapping(value = "nov",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rezultat> novRezultat(@RequestBody Rezultat rezultat){
        return new ResponseEntity(rezultatService.novRezultat(rezultat),HttpStatus.OK);
    }
}
