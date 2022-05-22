package com.bettoven.BetovenProject.services.drzava;

import com.bettoven.BetovenProject.services.liga.Liga;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.*;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "drzavaid")
@Entity
@Table(name = "drzava")
public class Drzava {
    //ID i ostale kolone

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drzavaid")
    private Integer drzavaid;

    @Column(name = "naziv",nullable = false)
    private String naziv;

    @JsonIgnore
    @OneToMany(mappedBy = "drzava",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Tim> timovi;

    @JsonIgnore
    @OneToMany(mappedBy = "drzavaLige",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Set<Liga> lige;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Drzava drzava = (Drzava) o;
        return drzavaid != null && Objects.equals(drzavaid, drzava.drzavaid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
