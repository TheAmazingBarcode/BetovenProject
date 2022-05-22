package com.bettoven.BetovenProject.repos;

import com.bettoven.BetovenProject.services.kvota.KvotaUcesnik;
import com.bettoven.BetovenProject.services.kvota.KvotaUcesnikID;
import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KvotaUcesnikRepository extends CrudRepository<KvotaUcesnik, KvotaUcesnikID> {
    List<KvotaUcesnik> findByMecid(Mec id);

    KvotaUcesnik findByKvotaTima(Tim tim);
}
