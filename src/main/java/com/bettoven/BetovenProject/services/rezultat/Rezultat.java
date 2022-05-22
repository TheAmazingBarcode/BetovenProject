package com.bettoven.BetovenProject.services.rezultat;

import com.bettoven.BetovenProject.services.mec.Mec;
import com.bettoven.BetovenProject.services.tim.Tim;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "rezultatid",scope = Rezultat.class)
@Table(name = "rezultat")
public class Rezultat {
    @Id
    @Column(name = "rezultatid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rezultatid;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="mecid",referencedColumnName = "mecid")
    private Mec odigraniMec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timid",nullable = false)
    @ToString.Exclude
    private Tim pobednickiTim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rezultat rezultat = (Rezultat) o;
        return rezultatid != null && Objects.equals(rezultatid, rezultat.rezultatid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
