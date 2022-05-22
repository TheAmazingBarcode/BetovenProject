package com.bettoven.BetovenProject.services.korisnik;

import com.bettoven.BetovenProject.services.uplata.Uplata;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

//Tabela korisnik

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "korisnik")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "korisnikid")
public class Korisnik {
    //ID korisnika i ostale kolone
    @Id
    @Column(name = "korisnikid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer korisnikid;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "balans")
    private Double balans = 0.00;

    @OneToMany(mappedBy = "izvorUplate",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private Set<Uplata> korisnickeUplate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Korisnik korisnik = (Korisnik) o;
        return korisnikid != null && Objects.equals(korisnikid, korisnik.korisnikid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
