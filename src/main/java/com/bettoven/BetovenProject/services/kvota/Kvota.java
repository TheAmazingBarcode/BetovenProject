package com.bettoven.BetovenProject.services.kvota;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequiredArgsConstructor
@Table(name = "kvota")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "kvotaid",scope = Kvota.class)
public class Kvota {
    @Id
    @Column(name = "kvotaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kvotaid;

    @Column(name = "vrednost",nullable = false)
    private Double vrednostKvote;

    @OneToMany(mappedBy = "kvotaid",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private Set<KvotaUcesnik> ucesceKvote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Kvota kvota = (Kvota) o;
        return kvotaid != null && Objects.equals(kvotaid, kvota.kvotaid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
