package ru.school.micro.services.country.entity;

import lombok.Data;

import java.util.List;

@Data
public class CountryData {
    private CountryName name;
    private String cca2;
    private Boolean independent;
    private String status;
    private List<String> capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Double area;
}
