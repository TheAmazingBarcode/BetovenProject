package com.bettoven.BetovenProject.services.kvota;

import com.bettoven.BetovenProject.repos.KvotaUcesnikRepository;
import com.bettoven.BetovenProject.repos.MecRepository;
import com.bettoven.BetovenProject.repos.TimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class KvotaUcesnikService {
    @Autowired
    private KvotaUcesnikRepository kvotaUcesnikRepository;

    @Autowired
    private MecRepository mecRepository;

    @Autowired
    private TimRepository timRepository;

    public List<KvotaUcesnik> svaUcesca(){
        return StreamSupport.stream(kvotaUcesnikRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    public KvotaUcesnik dodeliKvotu(KvotaUcesnik kvotaUcesnik){
       return kvotaUcesnikRepository.save(kvotaUcesnik);
   }

    public List<KvotaUcesnik> kvoteMeca(Integer id){
        return mecRepository.findById(id).get().getKvote().stream().toList();
    }

    public List<KvotaUcesnik> kvoteTima(String naziv){
        return timRepository.findByNaziv(naziv).getKvote().stream().toList();
    }

}
