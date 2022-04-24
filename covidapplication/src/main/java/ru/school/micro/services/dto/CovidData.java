package ru.school.micro.services.dto;

import lombok.Data;

@Data
public class CovidData {
    private CountryDto data;
    private String _cacheHit;
}
