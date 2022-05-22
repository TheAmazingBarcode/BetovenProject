package com.bettoven.BetovenProject.services.tim;

import com.bettoven.BetovenProject.repos.TimRepository;
import com.bettoven.BetovenProject.services.liga.Liga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TimService {
    @Autowired
    private TimRepository timRepository;

    public Tim ubaciTim(Tim tim){
        return timRepository.save(tim);
    }

    public List<Tim> sviTimovi(){
        return StreamSupport.stream(timRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public List<Tim> pretragaTimova(String naziv){
        return StreamSupport.stream(timRepository.findAll().spliterator(),true).collect(Collectors.toList()).stream().filter(tim -> tim.getNaziv().contains(naziv)).toList();
    }

    public List<Liga> ucesceTima(String naziv){
        return timRepository.findByNaziv(naziv).getUcesceLiga().stream().toList();
    }
}
