package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.kvota.KvotaUcesnik;
import com.bettoven.BetovenProject.services.kvota.KvotaUcesnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kvoteUcesca")
public class KvotaUcesnikAPI {
    @Autowired
    private KvotaUcesnikService kvotaUcesnikService;

    @GetMapping(value = "sva")
    public ResponseEntity<List<KvotaUcesnik>> svaUcescaKvota(){
        return new ResponseEntity(kvotaUcesnikService.svaUcesca(), HttpStatus.OK);
    }

    @GetMapping(value = "mec/{id}")
    public ResponseEntity<List<KvotaUcesnik>> kvoteMeca(@PathVariable(name = "id") Integer id){
        return new ResponseEntity(kvotaUcesnikService.kvoteMeca(id),HttpStatus.OK);
    }

    @GetMapping(value = "tim/{naziv}")
    public ResponseEntity<List<KvotaUcesnik>> kvoteTima(@PathVariable(name = "naziv") String naziv){
        return new ResponseEntity(kvotaUcesnikService.kvoteTima(naziv),HttpStatus.OK);
    }

    @PostMapping(value = "dodeli")
    public ResponseEntity<KvotaUcesnik> dodeliKvotu(@RequestBody KvotaUcesnik kvotaUcesnik){
        return new ResponseEntity<>(kvotaUcesnikService.dodeliKvotu(kvotaUcesnik),HttpStatus.OK);
    }
}
