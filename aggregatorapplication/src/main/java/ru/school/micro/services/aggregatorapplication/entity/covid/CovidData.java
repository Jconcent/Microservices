package ru.school.micro.services.aggregatorapplication.entity.covid;

import lombok.Data;

@Data
public class CovidData {
    private CountryDto data;
    private String _cacheHit;
}
