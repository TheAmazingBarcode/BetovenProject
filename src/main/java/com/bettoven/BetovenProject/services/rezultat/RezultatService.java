package com.bettoven.BetovenProject.services.rezultat;

import com.bettoven.BetovenProject.repos.KorisnikRepository;
import com.bettoven.BetovenProject.repos.KvotaUcesnikRepository;
import com.bettoven.BetovenProject.repos.MecRepository;
import com.bettoven.BetovenProject.repos.RezultatRepository;
import com.bettoven.BetovenProject.services.korisnik.Korisnik;
import com.bettoven.BetovenProject.services.kvota.KvotaUcesnik;
import com.bettoven.BetovenProject.services.uplata.Uplata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RezultatService {
    @Autowired
    private RezultatRepository rezultatRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private MecRepository mecRepository;

    @Autowired
    private KvotaUcesnikRepository kvotaUcesnikRepository;

    public List<Rezultat> sviRezultati(){
        return StreamSupport.stream(rezultatRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public Rezultat novRezultat(Rezultat rezultat){
//        List<Uplata> uspesneUplate =  rezultat.getOdigraniMec().getUplateMeca().stream().
//                filter(uplata -> uplata.getPredvidjeniTim().getTimid() == rezultat.getPobednickiTim().getTimid()).toList();

        mecRepository.findById(rezultat.getOdigraniMec().getMecid()).get().getUplateMeca().stream().filter(uplata -> uplata.getPredvidjeniTim().getTimid() == rezultat.getPobednickiTim().getTimid()).toList();

        List<Uplata> uspesneUplate =  mecRepository.findById(rezultat.getOdigraniMec().getMecid()).get().getUplateMeca().stream().filter(uplata -> uplata.getPredvidjeniTim().getTimid() == rezultat.getPobednickiTim().getTimid()).toList();

        uspesneUplate.forEach(uplata -> uplata.getIzvorUplate().setBalans(uplata.getIznosUplate()*kvotaUcesnikRepository.findByMecid(uplata.getUplaceniMec()).stream().filter(kvotaUcesnik -> kvotaUcesnik.getKvotaTima().getTimid() == uplata.getPredvidjeniTim().getTimid()).findAny().get().getKvotaid().getVrednostKvote()+uplata.getIzvorUplate().getBalans()));

        List<Korisnik> pobednickiKorisnici = new ArrayList();
        uspesneUplate.forEach(uplata -> pobednickiKorisnici.add(uplata.getIzvorUplate()));

        korisnikRepository.saveAll(pobednickiKorisnici);

        return rezultatRepository.save(rezultat);
    }
}
