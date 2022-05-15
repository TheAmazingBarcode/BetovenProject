package com.bettoven.BetovenProject.services.sport;

import com.bettoven.BetovenProject.repos.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SportService {
    @Autowired
    private SportRepository repository;

    public List<Sport> sviSportovi(){
        List<Sport> sportovi = StreamSupport.stream(repository.findAll().spliterator(),true).collect(Collectors.toList());
        return sportovi;
    }

    public Sport ubaciSport(Sport sport){
        return repository.save(sport);
    }

    public List<Sport> pretraziSport(String naziv){
        return StreamSupport.stream(repository.findAll().spliterator(),true).collect(Collectors.toList()).stream().filter(sport -> sport.getNaziv().contains(naziv)).toList();
    }
}
