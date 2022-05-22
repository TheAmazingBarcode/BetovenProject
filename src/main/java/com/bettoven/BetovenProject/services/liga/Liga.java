package com.bettoven.BetovenProject.services.liga;

import com.bettoven.BetovenProject.services.drzava.Drzava;
import com.bettoven.BetovenProject.services.kvota.Kvota;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "ligaid",scope = Kvota.class)
public class Liga {
    @Id
    @Column(name = "ligaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ligaid;

    @Column(name = "naziv",nullable = false)
    private String naziv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drzavaid")
    @ToString.Exclude
    private Drzava drzavaLige;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportid",referencedColumnName = "sportid")
    @ToString.Exclude
    private Sport sportLige;

    // n:m veza izmedju Lige i tima
    @ManyToMany
    @JoinTable(name = "ucesce_tima",
            joinColumns = {@JoinColumn(name = "ligaid")},
            inverseJoinColumns = {@JoinColumn(name = "timid")})
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
        return ligaid != null && Objects.equals(ligaid, liga.ligaid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
