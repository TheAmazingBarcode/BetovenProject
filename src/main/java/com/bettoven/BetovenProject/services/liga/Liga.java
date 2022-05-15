package com.bettoven.BetovenProject.services.liga;

import com.bettoven.BetovenProject.services.drzava.Drzava;
import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.sport.Sport;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "liga")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "ligaID")
public class Liga {
    @Id
    @Column(name = "ligaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ligaID;

    @Column(name = "naziv",nullable = false)
    private String naziv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drzavaID",nullable = false)
    @ToString.Exclude
    private Drzava drzavaTima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportID",nullable = false)
    @ToString.Exclude
    private Sport sport;

    // n:m veza izmedju Lige i tima
    @ManyToMany
    @JoinTable(name = "ucesce_tima",
            joinColumns = {@JoinColumn(name = "ligaID")},
            inverseJoinColumns = {@JoinColumn(name = "timID")})
    @ToString.Exclude
    private Set<Tim> ucesnici;

    @JsonIgnore
    @OneToMany(mappedBy = "odigranaLiga",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Mec> odigraniMecevi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Liga liga = (Liga) o;
        return ligaID != null && Objects.equals(ligaID, liga.ligaID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
