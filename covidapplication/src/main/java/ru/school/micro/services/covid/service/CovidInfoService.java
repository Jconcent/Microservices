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

    private Properties countryCodeProperty;

    public CovidInfoService() {
        this.countryCodeProperty = new Properties();
        loadProperty();
    }

    public CountryDto getCovidInfoByCountryName(String countryName) {
        RestTemplate restTemplate = new RestTemplate();
        String countryCode = countryCodeProperty.getProperty(countryName, "RU");
        ResponseEntity<CovidData> forEntity = restTemplate.getForEntity("https://corona-api.com/countries/" + countryCode, CovidData.class);
        return Optional.ofNullable(forEntity.getBody()).map(CovidData::getData).orElse(null);
    }

    private void loadProperty() {
        try (InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(
                this.getClass().getClassLoader().getResourceAsStream("countryName.properties")))) {
            this.countryCodeProperty.load(inputStreamReader);
        } catch (IOException e) {
            log.error("Error load property");
        }
    }
}
