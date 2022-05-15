package com.bettoven.BetovenProject.services.drzava;

import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

//Tabela drzava

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "drzavaID")
@Entity
@Table(name = "drzava")
public class Drzava {
    //ID i ostale kolone

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drzavaid")
    private Integer drzavaID;

    @Column(name = "naziv",nullable = false)
    private String naziv;

    @JsonIgnore
    @OneToMany(mappedBy = "drzava",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Tim> timovi;

    @JsonIgnore
    @OneToMany(mappedBy = "drzavaTima",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Liga> lige;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Drzava drzava = (Drzava) o;
        return drzavaID != null && Objects.equals(drzavaID, drzava.drzavaID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
