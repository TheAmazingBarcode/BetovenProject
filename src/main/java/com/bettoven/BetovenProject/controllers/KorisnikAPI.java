package com.bettoven.BetovenProject.controllers;

import com.bettoven.BetovenProject.services.uplata.Tranzakcija;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bettoven.BetovenProject.services.korisnik.Korisnik;
import com.bettoven.BetovenProject.services.korisnik.KorisnikService;

import java.util.List;

@RestController
@RequestMapping("korisnik")
public class KorisnikAPI {
    @Autowired
    private KorisnikService korisnikService;

    @PostMapping(value = "registruj",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> registrujKorisnika(@RequestBody Korisnik novKorisnik){
        return new ResponseEntity(korisnikService.registrujKorisnika(novKorisnik), HttpStatus.CREATED);
    }

    @GetMapping(value = "svi")
    public ResponseEntity<List<Korisnik>> sviKorisnici(){
        return new ResponseEntity(korisnikService.sviKorisnici(), HttpStatus.OK);
    }

    @GetMapping(value = "uloguj",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> ulogujKorisnika(@RequestBody Korisnik korisnikZaProveru){
        return new ResponseEntity(korisnikService.daLiPostojiKorisnik(korisnikZaProveru),HttpStatus.OK);
    }

    @PutMapping(value = "dodajPare",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> dodajPare(@RequestBody Tranzakcija tranzakcija){
        return new ResponseEntity(korisnikService.dodajPare(tranzakcija),HttpStatus.OK);
    }
}
