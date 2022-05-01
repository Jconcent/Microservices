package ru.school.micro.services.country.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.school.micro.services.country.entity.CountryData;

import java.util.Arrays;

@Service
@AllArgsConstructor
@Slf4j
public class CountriesService {

    public CountryData getCountryInfoByName(String countryName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CountryData[]> forEntity = restTemplate.getForEntity("https://restcountries.com/v3.1/name/" + countryName, CountryData[].class);

        return Arrays.stream(forEntity.getBody()).findFirst().orElse(null);
    }
}
