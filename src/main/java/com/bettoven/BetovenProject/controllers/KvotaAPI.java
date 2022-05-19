package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.kvota.Kvota;
import com.bettoven.BetovenProject.services.kvota.KvotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "kvota")
public class KvotaAPI {
    @Autowired
    private KvotaService kvotaService;

    @GetMapping(value = "sve")
    public ResponseEntity<List<Kvota>> sveKvote(){
        return new ResponseEntity(kvotaService.sveKvote(), HttpStatus.OK);
    }

    @PostMapping(value = "ubaci",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Kvota> ubaciKvotu(@RequestBody Kvota kvota){
        return new ResponseEntity(kvotaService.dodajKvotu(kvota),HttpStatus.OK);
    }
}
