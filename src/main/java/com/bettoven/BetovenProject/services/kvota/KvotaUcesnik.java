package com.bettoven.BetovenProject.services.kvota;

import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "kvota_ucesnici")
public class KvotaUcesnik {
    @EmbeddedId
    private KvotaUcesnikID kvotaUcesnikID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mecKvotaID")
    @JsonBackReference(value = "kvote-meca")
    @ToString.Exclude
    private Mec mec;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("kvotaUcesnikID")
    @ToString.Exclude
    private Kvota kvota;

    @JsonBackReference(value = "timske-kvote")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timID")
    @ToString.Exclude
    private Tim kvotaTima;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KvotaUcesnik that = (KvotaUcesnik) o;
        return kvotaUcesnikID != null && Objects.equals(kvotaUcesnikID, that.kvotaUcesnikID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kvotaUcesnikID);
    }
}
