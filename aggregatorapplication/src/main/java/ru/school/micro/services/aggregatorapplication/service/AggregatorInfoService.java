package ru.school.micro.services.aggregatorapplication.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.school.micro.services.aggregatorapplication.entity.AggregatedInfo;
import ru.school.micro.services.aggregatorapplication.entity.country.CountryData;
import ru.school.micro.services.aggregatorapplication.entity.covid.CountryDto;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AggregatorInfoService {

    private final String covidServiceURL = "http://localhost/covid-management/countries/";
    private final String countryServiceURL = "http://localhost:/countries-management/countries/";

    public AggregatedInfo getInfo(String countryName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CountryData> countryRs = restTemplate.getForEntity(countryServiceURL + countryName, CountryData.class);
        CountryData countryRsBody = Optional.ofNullable(countryRs.getBody()).orElse(new CountryData());
        log.info("Country response: {}", countryRsBody);

        ResponseEntity<CountryDto> covidRs = restTemplate.getForEntity(covidServiceURL + countryRsBody.getCca2(), CountryDto.class);
        CountryDto covidRsBody = Optional.ofNullable(covidRs.getBody()).orElse(new CountryDto());
        log.info("Covid response: {}", covidRsBody);

        return new AggregatedInfo(covidRsBody, countryRsBody);
    }
}
