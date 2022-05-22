package com.bettoven.BetovenProject.services.statistika;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashMap;


@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class StatistikaKvoteView {
    private Integer mecId;

    private HashMap<String,Double> kvoteTimova;

    private Date datum;
}
