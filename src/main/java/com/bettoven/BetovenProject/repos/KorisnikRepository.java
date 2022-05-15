package com.bettoven.BetovenProject.repos;

import org.springframework.data.repository.CrudRepository;
import com.bettoven.BetovenProject.services.korisnik.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik,Integer> {
    Korisnik findByEmailAndPassword(String email,String password);
}
