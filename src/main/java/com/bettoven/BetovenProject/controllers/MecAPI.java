package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.mec.MecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mec")
public class MecAPI {
    @Autowired
    private MecService mecService;

    @GetMapping(value = "svi")
    public ResponseEntity<List<Mec>> sviMecevi(){
        return new ResponseEntity(mecService.sviMecevi(), HttpStatus.OK);
    }

    @GetMapping(value = "liga/{naziv}")
    public ResponseEntity<List<Mec>> meceviLige(@PathVariable(name = "naziv") String naziv){
        return new ResponseEntity(mecService.meceviLige(naziv),HttpStatus.OK);
    }

    @GetMapping(value = "tim/{naziv}")
    public ResponseEntity<List<Mec>> meceviTima(@PathVariable(name = "naziv") String naziv){
        return new ResponseEntity(mecService.odigraniMeceviTima(naziv),HttpStatus.OK);
    }

    @PostMapping(value = "nov")
    public ResponseEntity<Mec> zapocniNovMec(@RequestBody Mec mec){
        return new ResponseEntity(mecService.zapocniMec(mec),HttpStatus.OK);
    }
}
