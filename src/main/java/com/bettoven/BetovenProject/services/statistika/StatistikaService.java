package com.bettoven.BetovenProject.services.statistika;

import com.bettoven.BetovenProject.repos.KvotaUcesnikRepository;
import com.bettoven.BetovenProject.repos.MecRepository;
import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class StatistikaService {
    @Autowired
    private KvotaUcesnikRepository kvotaUcesnikRepository;

    @Autowired
    private MecRepository mecRepository;

    public StatistikaKvoteView pregledMeca(Integer id){
      Mec mec =  mecRepository.findById(id).get();

      StatistikaKvoteView pregled =  new StatistikaKvoteView();
      pregled.setMecId(kvotaUcesnikRepository.findByMecid(mec).get(0).getMecid().getMecid());

      HashMap<String,Double> timoviKvote = new HashMap<>();

      kvotaUcesnikRepository.findByMecid(mec).stream().
              forEach(kvotaUcesnik -> timoviKvote.put(kvotaUcesnik.getKvotaTima().getNaziv(),
                                                        kvotaUcesnik.getKvotaid().getVrednostKvote()));

      pregled.setKvoteTimova(timoviKvote);
      pregled.setDatum(mec.getDatum());

      return pregled;
    }
}
