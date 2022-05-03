package ru.school.micro.services.aggregatorapplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.school.micro.services.aggregatorapplication.entity.AggregatedInfo;
import ru.school.micro.services.aggregatorapplication.service.AggregatorInfoService;

@RestController
@AllArgsConstructor
public class AggregatorController {

    private final AggregatorInfoService service;

    @GetMapping("/information-management/countries/{country-name}")
    public ResponseEntity<AggregatedInfo> getCountryInfoWithCovid(@PathVariable("country-name") String countryName) {
        return ResponseEntity.ok(service.getInfo(countryName));
    }
}
