package com.bettoven.BetovenProject.repos;

import com.bettoven.BetovenProject.services.drzava.Drzava;
import org.springframework.data.repository.CrudRepository;

public interface DrzavaRepository extends CrudRepository<Drzava,Integer> {
    Drzava findByNaziv(String naziv);
}
