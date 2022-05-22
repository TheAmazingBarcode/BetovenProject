package com.bettoven.BetovenProject.services.korisnik;

import com.bettoven.BetovenProject.services.uplata.Tranzakcija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bettoven.BetovenProject.repos.KorisnikRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    public List<Korisnik> sviKorisnici(){
        return StreamSupport.stream(korisnikRepo.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public Korisnik registrujKorisnika(Korisnik novKorisnik){
        return korisnikRepo.save(novKorisnik);
    }

    public Korisnik daLiPostojiKorisnik(Korisnik korisnikZaProveru){
        String email = korisnikZaProveru.getEmail();
        String password = korisnikZaProveru.getPassword();
        return korisnikRepo.findByEmailAndPassword(email,password);
    }

    public Korisnik dodajPare(Tranzakcija tranzakcija){
        Korisnik korisnik = korisnikRepo.findById(tranzakcija.getPrimaoc()).get();
        korisnik.setBalans(korisnik.getBalans()+ tranzakcija.getIznos());
        return korisnikRepo.save(korisnik);
    }

}
