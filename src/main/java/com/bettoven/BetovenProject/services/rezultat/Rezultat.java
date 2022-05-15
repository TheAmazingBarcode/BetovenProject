package com.bettoven.BetovenProject.services.rezultat;

import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "rezultatID")
@Table(name = "rezultat")
public class Rezultat {
    @Id
    @Column(name = "rezultatid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rezultatID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="mec_id",referencedColumnName = "mecID")
    private Mec odigraniMec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timID",nullable = false)
    @ToString.Exclude
    private Tim pobednickiTim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rezultat rezultat = (Rezultat) o;
        return rezultatID != null && Objects.equals(rezultatID, rezultat.rezultatID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
