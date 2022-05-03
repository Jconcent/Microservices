package ru.school.micro.services.aggregatorapplication.entity.covid;

import lombok.Data;

@Data
public class TodayInfoDto {

    private Integer deaths;
    private Integer confirmed;
}
