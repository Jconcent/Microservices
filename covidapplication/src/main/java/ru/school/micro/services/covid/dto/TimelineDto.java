package ru.school.micro.services.covid.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TimelineDto {
    private Date updatedAt;
    private Date date;
    private Integer deaths;
    private Integer confirmed;
    private Integer recovered;
    private Integer active;
    private Integer newConfirmed;
    private Integer newRecovered;
    private Integer newDeaths;
    private Boolean isInProgress;
}
