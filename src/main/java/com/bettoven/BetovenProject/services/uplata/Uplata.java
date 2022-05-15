package com.bettoven.BetovenProject.services.uplata;

import com.bettoven.BetovenProject.services.korisnik.Korisnik;
import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "uplataID")
@Table(name = "uplata")
public class Uplata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uplataid")
    private Integer uplataID;

    @Column(name = "iznos")
    private Double iznosUplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikID")
    @ToString.Exclude
    private Korisnik izvorUplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mecID",nullable = false)
    @ToString.Exclude
    private Mec uplaceniMec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timID",nullable = false)
    @ToString.Exclude
    private Tim predvidjeniTim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uplata uplata = (Uplata) o;
        return uplataID != null && Objects.equals(uplataID, uplata.uplataID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
