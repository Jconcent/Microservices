package ru.school.micro.services.aggregatorapplication.entity.country;

import lombok.Data;

import java.util.List;

@Data
public class CountryInfo {
    List<CountryData> countryData;
}
