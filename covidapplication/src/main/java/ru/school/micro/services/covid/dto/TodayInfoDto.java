package ru.school.micro.services.covid.dto;

import lombok.Data;

@Data
public class TodayInfoDto {

    private Integer deaths;
    private Integer confirmed;
}
