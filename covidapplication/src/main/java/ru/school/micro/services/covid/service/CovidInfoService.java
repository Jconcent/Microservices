package ru.school.micro.services.covid.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.school.micro.services.covid.dto.CountryDto;
import ru.school.micro.services.covid.dto.CovidData;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

@Service
@AllArgsConstructor
@Slf4j
public class CovidInfoService {

    public CountryDto getCovidInfoByCountryName(String countryName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CovidData> forEntity = restTemplate.getForEntity("https://corona-api.com/countries/" + countryName, CovidData.class);
        return Optional.ofNullable(forEntity.getBody()).map(CovidData::getData).orElse(null);
    }
}
