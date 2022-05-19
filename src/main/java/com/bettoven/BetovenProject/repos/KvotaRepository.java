package com.bettoven.BetovenProject.repos;

import com.bettoven.BetovenProject.services.kvota.Kvota;
import org.springframework.data.repository.CrudRepository;

public interface KvotaRepository extends CrudRepository<Kvota,Integer> {
}
