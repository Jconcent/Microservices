package ru.school.micro.services.aggregatorapplication.entity.covid;

import lombok.Data;

@Data
public class CalculatedDto {
    private Float deathRate;
    private Float recoveryRate;
    private Float recoveredVsDeathRatio;
    private Float casesPerMillionPopulation;
}
