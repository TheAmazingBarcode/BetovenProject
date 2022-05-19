package com.bettoven.BetovenProject.services.kvota;

import com.bettoven.BetovenProject.repos.KvotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class KvotaService {
    @Autowired
    private KvotaRepository kvotaRepository;

    public Kvota dodajKvotu(Kvota kvota){
        return kvotaRepository.save(kvota);
    }

    public List<Kvota> sveKvote(){
        return StreamSupport.stream(kvotaRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }
}
