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
    @Column(name = "mec_id")
    private Integer mecKvotaID;

    @Column(name = "kvota_id")
    private Integer kvotaUcesnikID;
}
