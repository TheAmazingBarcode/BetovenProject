package com.bettoven.BetovenProject.services.sport;

import com.bettoven.BetovenProject.services.liga.Liga;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

//Tabela sport

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sport")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "sportid")
public class Sport {
    //Id sporta i ostale kolone

    @Id
    @Column(name = "sportid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sportid;

    @Column(name = "naziv",nullable = false)
    private String naziv;

    @JsonIgnore
    @OneToMany(mappedBy = "sportLige",orphanRemoval = true,cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Liga> lige;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sport sport = (Sport) o;
        return sportid != null && Objects.equals(sportid, sport.sportid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
