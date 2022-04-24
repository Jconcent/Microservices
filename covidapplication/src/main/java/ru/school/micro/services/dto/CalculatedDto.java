package ru.school.micro.services.dto;

import lombok.Data;

@Data
public class CalculatedDto {
    private Float deathRate;
    private Float recoveryRate;
    private Float recoveredVsDeathRatio;
    private Float casesPerMillionPopulation;
}
