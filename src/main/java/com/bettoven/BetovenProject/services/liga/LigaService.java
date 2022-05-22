package com.bettoven.BetovenProject.services.liga;

import com.bettoven.BetovenProject.repos.LigaRepository;
import com.bettoven.BetovenProject.repos.TimRepository;
import com.bettoven.BetovenProject.services.tim.Tim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LigaService {
    @Autowired
    private LigaRepository ligaRepository;

    @Autowired
    private TimRepository timRepository;

    public Liga ubaciLigu(Liga liga){
        System.out.println(liga.getDrzavaLige().getDrzavaid());
        return ligaRepository.save(liga);
    }

    public List<Liga> sveLige(){
        return StreamSupport.stream(ligaRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public List<Liga> pretragaLige(String naziv){
        return StreamSupport.stream(ligaRepository.findAll().spliterator(),true).collect(Collectors.toList()).stream().filter(liga -> liga.getNaziv().contains(naziv)).toList();
    }

    public List<Tim> timoviLige(String naziv){
        return ligaRepository.findByNaziv(naziv).getUcesnici().stream().toList();
    }

    public Liga ubaciTimULigu(String nazivTima,String nazivLige){
        Liga liga = ligaRepository.findByNaziv(nazivLige);
        Tim tim  = timRepository.findByNaziv(nazivTima);

        liga.getUcesnici().add(tim);
        return ligaRepository.save(liga);
    }

    public Liga izbaciTimIzLige(String nazivTima,String nazivLige){
        Liga liga = ligaRepository.findByNaziv(nazivLige);
        Tim tim  = timRepository.findByNaziv(nazivTima);

        liga.getUcesnici().remove(tim);
        return ligaRepository.save(liga);
    }
}
