package ru.school.micro.services.aggregatorapplication.entity.covid;

import lombok.Data;

@Data
public class LatestDataDto {

    private Integer deaths;
    private Integer confirmed;
    private Integer recovered;
    private Integer critical;
    private CalculatedDto calculated;
}
