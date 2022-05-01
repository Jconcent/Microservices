package ru.school.micro.services.country.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.school.micro.services.country.entity.CountryData;
import ru.school.micro.services.country.service.CountriesService;

@RestController
@AllArgsConstructor
public class CountriesController {

    private final CountriesService countriesService;

    @GetMapping("/countries-management/countries/{country-name}")
    public ResponseEntity<CountryData> getCountryInfo(@PathVariable("country-name") String countryName) {
        return ResponseEntity.ok(countriesService.getCountryInfoByName(countryName));
    }
}
