package com.bettoven.BetovenProject.services.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bettoven.BetovenProject.repos.KorisnikRepository;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    public Korisnik registrujKorisnika(Korisnik novKorisnik){
        return korisnikRepo.save(novKorisnik);
    }

    public Korisnik daLiPostojiKorisnik(Korisnik korisnikZaProveru){
        String email = korisnikZaProveru.getEmail();
        String password = korisnikZaProveru.getPassword();
        return korisnikRepo.findByEmailAndPassword(email,password);
    }

}
