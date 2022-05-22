package com.bettoven.BetovenProject.services.uplata;

import com.bettoven.BetovenProject.repos.KorisnikRepository;
import com.bettoven.BetovenProject.repos.UplataRepository;
import com.bettoven.BetovenProject.services.korisnik.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UplataService {
    @Autowired
    private UplataRepository uplataRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Uplata> sveUplate(){
        return StreamSupport.stream(uplataRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public List<Uplata> uplateKorisnika(Integer id){
        return uplataRepository.findByIzvorUplate(korisnikRepository.findById(id).get());
    }

    public Uplata novaUplata(Uplata uplata){
        if(korisnikRepository.findById(uplata.getIzvorUplate().getKorisnikid()).get().getBalans() < uplata.getIznosUplate())
            return null;
        else {
            Korisnik korisnik = korisnikRepository.findById(uplata.getIzvorUplate().getKorisnikid()).get();
            korisnik.setBalans(korisnik.getBalans()-uplata.getIznosUplate());
            korisnikRepository.save(korisnik);
            return uplataRepository.save(uplata);
        }
    }


}
