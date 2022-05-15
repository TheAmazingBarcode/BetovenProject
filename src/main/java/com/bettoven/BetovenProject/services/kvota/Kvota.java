package com.bettoven.BetovenProject.services.kvota;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "kvota")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "kvotaID")
public class Kvota {
    @Id
    @Column(name = "kvotaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kvotaID;

    @Column(name = "vrednost",nullable = false)
    private Double vrednostKvote;

    @OneToMany(mappedBy = "kvota",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private Set<KvotaUcesnik> ucesceKvote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Kvota kvota = (Kvota) o;
        return kvotaID != null && Objects.equals(kvotaID, kvota.kvotaID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
