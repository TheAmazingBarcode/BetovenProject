package com.bettoven.BetovenProject.services.uplata;

import com.bettoven.BetovenProject.services.korisnik.Korisnik;
import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "uplataid",scope = Uplata.class)
@Table(name = "uplata")
public class Uplata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uplataid")
    private Integer uplataid;

    @Column(name = "iznos")
    private Double iznosUplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikid")
    @ToString.Exclude
    private Korisnik izvorUplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mecid",nullable = false)
    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    private Mec uplaceniMec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timid",nullable = false)
    @ToString.Exclude
    private Tim predvidjeniTim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uplata uplata = (Uplata) o;
        return uplataid != null && Objects.equals(uplataid, uplata.uplataid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
