package com.bettoven.BetovenProject.services.drzava;

import com.bettoven.BetovenProject.repos.DrzavaRepository;
import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.tim.Tim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DrzavaService {
    @Autowired
    private DrzavaRepository drzavaRepository;

    public List<Drzava> izlistajSveDrzave(){
      return StreamSupport.stream(drzavaRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public List<Drzava> pretragaDrzava(String naziv){
        return StreamSupport.stream(drzavaRepository.findAll().spliterator(),true).collect(Collectors.toList()).stream().filter(drzava -> drzava.getNaziv().contains(naziv)).toList();
    }

    public Drzava ubaciDrzavu(Drzava drzava){
        return drzavaRepository.save(drzava);
    }

    public List<Liga> ligeDrzave(String naziv){
        return drzavaRepository.findByNaziv(naziv).getLige().stream().toList();
    }

    public List<Tim> timoviDrzave(String naziv){
        return drzavaRepository.findByNaziv(naziv).getTimovi().stream().toList();
    }
}
