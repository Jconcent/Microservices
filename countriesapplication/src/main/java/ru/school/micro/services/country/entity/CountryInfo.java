package ru.school.micro.services.country.entity;

import lombok.Data;

import java.util.List;

@Data
public class CountryInfo {
    List<CountryData> countryData;
}
