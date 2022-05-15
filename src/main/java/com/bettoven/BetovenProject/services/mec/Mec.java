package com.bettoven.BetovenProject.services.mec;

import com.bettoven.BetovenProject.services.kvota.KvotaUcesnik;
import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.rezultat.Rezultat;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.bettoven.BetovenProject.services.uplata.Uplata;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "mec")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "mecID")
public class Mec {
    @Id
    @Column(name = "mecid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mecID;

    @Column(name = "datum",nullable = false)
    private Date datum;

    @ManyToOne
    @JoinColumn(name = "ligaID",nullable = false)
    private Liga odigranaLiga;

    @OneToMany(mappedBy = "mec",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private Set<KvotaUcesnik> kvote;

    @ManyToMany
    @JoinTable(name = "mec_ucesnici",
            joinColumns = {@JoinColumn(name = "mecID")}
            ,inverseJoinColumns = {@JoinColumn(name = "timID")})
    @ToString.Exclude
    private Set<Tim> ucesniciMeca;

    @OneToOne(mappedBy = "odigraniMec")
    private Rezultat rezultatMeca;

    @OneToMany(mappedBy = "uplaceniMec",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private Set<Uplata> uplateMeca;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mec mec = (Mec) o;
        return mecID != null && Objects.equals(mecID, mec.mecID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
