package ru.school.micro.services.aggregatorapplication.entity;

import lombok.Data;
import ru.school.micro.services.aggregatorapplication.entity.country.CountryData;
import ru.school.micro.services.aggregatorapplication.entity.covid.CountryDto;

@Data
public class AggregatedInfo {
    private String countyName;
    private String capital;
    private Double area;
    private Long population;
    private int deaths;
    private int recovered;

    public AggregatedInfo(CountryDto covidData, CountryData countryData) {
        this.countyName = countryData.getName().getOfficial();
        this.capital = countryData.getCapital().get(0);
        this.area = countryData.getArea();
        this.population = covidData.getPopulation();
        this.deaths = covidData.getLatest_data().getDeaths();
        this.recovered = covidData.getLatest_data().getRecovered();
    }
}
