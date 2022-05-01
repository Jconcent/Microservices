package ru.school.micro.services.covid.dto;

import lombok.Data;

@Data
public class CovidData {
    private CountryDto data;
    private String _cacheHit;
}
