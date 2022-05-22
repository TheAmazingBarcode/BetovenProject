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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequiredArgsConstructor
@Table(name = "mec")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "mecid",scope = Mec.class)
public class Mec {
    @Id
    @Column(name = "mecid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mecid;

    @Column(name = "datum",nullable = false)
    private Date datum;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "ligaid",nullable = false)
    private Liga odigranaLiga;

    @OneToMany(mappedBy = "mecid",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private Set<KvotaUcesnik> kvote;

    @ManyToMany
    @JoinTable(name = "mec_ucesnici",
            joinColumns = {@JoinColumn(name = "mecid")}
            ,inverseJoinColumns = {@JoinColumn(name = "timid")})
    @ToString.Exclude
    private Set<Tim> ucesniciMeca;

    @OneToOne(mappedBy = "odigraniMec")
    @JsonIgnore
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
        return mecid != null && Objects.equals(mecid, mec.mecid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
