package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.drzava.Drzava;
import com.bettoven.BetovenProject.services.drzava.DrzavaService;
import com.bettoven.BetovenProject.services.sport.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drzava")
public class DrzavaAPI {
    @Autowired
    private DrzavaService drzavaService;

    @GetMapping(value = "sve")
    public ResponseEntity<List<Drzava>> sveDrzave(){
        return new ResponseEntity(drzavaService.izlistajSveDrzave(), HttpStatus.OK);
    }

    @GetMapping(value = "pretraga/{naziv}")
    public ResponseEntity<List<Drzava>> pretragaDrzava(@PathVariable(name = "naziv") String naziv){
        return new ResponseEntity(drzavaService.pretragaDrzava(naziv),HttpStatus.OK);
    }

    @PostMapping(value = "ubaci",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Drzava> ubaciNovuDrzavu(@RequestBody Drzava drzava){
        return new ResponseEntity(drzavaService.ubaciDrzavu(drzava),HttpStatus.OK);
    }
}
