package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.uplata.Uplata;
import com.bettoven.BetovenProject.services.uplata.UplataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("uplata")
public class UplataAPI {
    @Autowired
    private UplataService uplataService;

    @GetMapping(value = "sve")
    public ResponseEntity<List<Uplata>> sveUplate(){
        return new ResponseEntity(uplataService.sveUplate(),HttpStatus.OK);
    }

    @GetMapping(value = "korisnik/{idKorisnika}")
    public ResponseEntity<List<Uplata>> uplateKorisnika(@PathVariable(name = "idKorisnika") Integer id){
        return new ResponseEntity(uplataService.uplateKorisnika(id),HttpStatus.OK);
    }

    @PostMapping(value = "nova")
    public ResponseEntity<Uplata> novaUplata(@RequestBody Uplata uplata){
        return new ResponseEntity(uplataService.novaUplata(uplata), HttpStatus.OK);
    }
}
