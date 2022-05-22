package com.bettoven.BetovenProject.services.kvota;

import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="kvotaUcesnikID", scope = KvotaUcesnik.class)
@Table(name = "kvota_ucesnici")
public class KvotaUcesnik {
    @EmbeddedId
    private KvotaUcesnikID kvotaUcesnikID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mecid")
    @MapsId("mecid")
    @ToString.Exclude
    private Mec mecid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kvotaid")
    @MapsId("kvotaid")
    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    private Kvota kvotaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timid")
    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
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
