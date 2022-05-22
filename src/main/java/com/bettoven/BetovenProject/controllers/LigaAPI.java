package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.liga.LigaService;
import com.bettoven.BetovenProject.services.tim.Tim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "liga")
public class LigaAPI {
    @Autowired
    private LigaService ligaService;

    @GetMapping(value = "sve")
    public ResponseEntity<List<Liga>> sveLige(){
        return new ResponseEntity(ligaService.sveLige(), HttpStatus.OK);
    }

    @GetMapping(value = "pretraga/{naziv}")
    public ResponseEntity<List<Liga>> pretragaLiga(@PathVariable(name = "naziv") String naziv){
        return new ResponseEntity(ligaService.pretragaLige(naziv),HttpStatus.OK);
    }

    @GetMapping(value = "timovi/{nazivLige}")
    public ResponseEntity<List<Tim>> timoviLige(@PathVariable(name = "nazivLige") String naziv){
        return new ResponseEntity(ligaService.timoviLige(naziv),HttpStatus.OK);
    }

    @PostMapping(value = "ubaci",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Liga> novaLiga(@RequestBody Liga liga){
        return new ResponseEntity(ligaService.ubaciLigu(liga),HttpStatus.OK);
    }

    @PutMapping(value = "ubaciTim/{nazivTima}/{nazivLige}")
    public ResponseEntity<Liga> ubaciTimULigu(@PathVariable(name = "nazivTima") String nazivTima,@PathVariable(name = "nazivLige") String nazivLige){
        return new ResponseEntity(ligaService.ubaciTimULigu(nazivTima,nazivLige),HttpStatus.OK);
    }

    @PutMapping(value = "izbaciTim/{nazivTima}/{nazivLige}")
    public ResponseEntity<Liga> izbaciTimIzLige(@PathVariable(name = "nazivTima") String nazivTima,@PathVariable(name = "nazivLige") String nazivLige){
        return new ResponseEntity(ligaService.izbaciTimIzLige(nazivTima,nazivLige),HttpStatus.OK);
    }
}
