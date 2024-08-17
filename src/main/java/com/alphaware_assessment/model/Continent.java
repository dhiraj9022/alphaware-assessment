package com.alphaware_assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "continents")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private Long areaSqKm;
    private Long population;
    private Integer countries;

    @ElementCollection
    private List<String> lines;

    @ElementCollection
    private List<String> oceans;

    @ElementCollection
    private List<String> developedCountries;
}
