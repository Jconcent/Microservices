package ru.school.micro.services.covid.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.school.micro.services.covid.dto.CountryDto;
import ru.school.micro.services.covid.service.CovidInfoService;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Slf4j
public class CovidInfoController {

    private final CovidInfoService covidInfoService;

    @GetMapping("/covid-management/countries/{country-name}")
    public ResponseEntity<CountryDto> getCovidInfoByCountryName(@PathVariable("country-name") String countryName) throws IOException {
        log.info("Server request: {}", countryName);
        return ResponseEntity.ok(covidInfoService.getCovidInfoByCountryName(countryName));
    }
}
