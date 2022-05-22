package com.bettoven.BetovenProject.services.kvota;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
public class KvotaUcesnikID implements Serializable {
    @Column(name = "mecid")
    private Integer mecid;

    @Column(name = "kvotaid")
    private Integer kvotaid;
}
