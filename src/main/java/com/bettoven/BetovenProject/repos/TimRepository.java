package com.bettoven.BetovenProject.repos;

import com.bettoven.BetovenProject.services.tim.Tim;
import org.springframework.data.repository.CrudRepository;

public interface TimRepository extends CrudRepository<Tim,Integer> {
    Tim findByNaziv(String naziv);
}
