package com.alphaware_assessment.dto;

import lombok.*;
import java.util.List;

@Data
public class ContinentDTO {
    private String code;
    private String name;
    private Long areaSqKm;
    private Long population;
    private Integer countries;
    private List<String> lines;
    private List<String> oceans;
    private List<String> developedCountries;
}
