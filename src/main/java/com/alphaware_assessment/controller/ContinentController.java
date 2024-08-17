package com.alphaware_assessment.controller;

import com.alphaware_assessment.model.Continent;
import com.alphaware_assessment.service.ContinentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/continents")
public class ContinentController {

    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping("/fetch")
    public List<Continent> getAndSaveContinents() {
        return continentService.fetchAndSaveContinents();
    }

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

}
