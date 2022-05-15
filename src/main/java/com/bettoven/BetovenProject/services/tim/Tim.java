package com.bettoven.BetovenProject.services.tim;

import com.bettoven.BetovenProject.services.drzava.Drzava;
import com.bettoven.BetovenProject.services.kvota.KvotaUcesnik;
import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.rezultat.Rezultat;
import com.bettoven.BetovenProject.services.uplata.Uplata;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

//Tabela tim

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "timID")
public class Tim {
    //ID i ostale kolone

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timid")
    private Integer timID;

    @Column(name = "naziv",nullable = false)
    private String naziv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drzavaID",nullable = false)
    @ToString.Exclude
    private Drzava drzava;

    //n:m veza izmedju Lige i tima
    @ManyToMany(mappedBy = "ucesnici")
    @JsonIgnore
    @ToString.Exclude
    private Set<Liga> ucesceLiga;

    @ManyToMany(mappedBy = "ucesniciMeca")
    @ToString.Exclude
    private Set<Mec> mecevi;

    @JsonManagedReference(value = "timske-kvote")
    @OneToMany(mappedBy = "kvotaTima",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<KvotaUcesnik> kvote;

    @JsonIgnore
    @OneToMany(mappedBy = "pobednickiTim",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Rezultat> pobedeTima;

    @JsonIgnore
    @OneToMany(mappedBy = "predvidjeniTim",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Uplata> uplateNaTim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tim tim = (Tim) o;
        return timID != null && Objects.equals(timID, tim.timID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
