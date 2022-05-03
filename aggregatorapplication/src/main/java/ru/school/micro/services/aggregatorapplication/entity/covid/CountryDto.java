package ru.school.micro.services.aggregatorapplication.entity.covid;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CountryDto {
    private CoordinatesDto coordinates;
    private String name;
    private String code;
    private Long population;
    private Date updatedAt;
    private TodayInfoDto today;
    private LatestDataDto latest_data;
    private List<TimelineDto> timeline;
}
