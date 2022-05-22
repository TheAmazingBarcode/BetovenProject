package com.bettoven.BetovenProject.services.mec;

import com.bettoven.BetovenProject.repos.LigaRepository;
import com.bettoven.BetovenProject.repos.MecRepository;
import com.bettoven.BetovenProject.repos.TimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MecService {
    @Autowired
    private MecRepository mecRepository;

    @Autowired
    private LigaRepository ligaRepository;

    @Autowired
    private TimRepository timRepository;

    public Mec zapocniMec(Mec mec){
        return mecRepository.save(mec);
    }

    public List<Mec> sviMecevi(){
        return StreamSupport.stream(mecRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public List<Mec> meceviLige(String naziv){
        return ligaRepository.findByNaziv(naziv).getOdigraniMecevi().stream().toList();
    }

    public List<Mec> odigraniMeceviTima(String naziv){
        return timRepository.findByNaziv(naziv).getMecevi().stream().toList();
    }
}
