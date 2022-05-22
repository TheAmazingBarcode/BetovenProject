package com.bettoven.BetovenProject.repos;

import com.bettoven.BetovenProject.services.korisnik.Korisnik;
import com.bettoven.BetovenProject.services.uplata.Uplata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UplataRepository extends CrudRepository<Uplata,Integer> {
    List<Uplata> findByIzvorUplate(Korisnik korisnik);
}
