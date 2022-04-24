package ru.school.micro.services.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.school.micro.services.dto.CountryDto;
import ru.school.micro.services.dto.CovidData;

import java.util.Optional;

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
