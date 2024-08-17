package com.alphaware_assessment.service;

import com.alphaware_assessment.dto.ContinentDTO;
import com.alphaware_assessment.exception.ContinentAlreadyExistsException;
import com.alphaware_assessment.model.Continent;
import com.alphaware_assessment.repo.ContinentRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContinentService {

    private final RestTemplate restTemplate;
    private final ContinentRepository continentRepo;

    public ContinentService(RestTemplate restTemplate, ContinentRepository continentRepo) {
        this.restTemplate = restTemplate;
        this.continentRepo = continentRepo;
    }

    public List<Continent> fetchAndSaveContinents() {

        String url = "https://dummy-json.mock.beeceptor.com/continents";
        ResponseEntity<List<ContinentDTO>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        List<ContinentDTO> continentDTOs = response.getBody();
        List<Continent> continents = new ArrayList<>();

        if (continentDTOs != null) {
            for (ContinentDTO dto : continentDTOs) {

                if (continentRepo.existsByCode(dto.getCode())) {
                    throw new ContinentAlreadyExistsException("Continent with code " + dto.getCode() + " already exists");
                }

                Continent continent = new Continent();
                continent.setCode(dto.getCode());
                continent.setName(dto.getName());
                continent.setAreaSqKm(dto.getAreaSqKm());
                continent.setPopulation(dto.getPopulation());
                continent.setCountries(dto.getCountries());
                continent.setLines(dto.getLines());
                continent.setOceans(dto.getOceans());
                continent.setDevelopedCountries(dto.getDevelopedCountries());
                continents.add(continent);
            }
            continentRepo.saveAll(continents);
        }
        return continents;
    }

    public List<Continent> getAllContinents() {
        return continentRepo.findAll();
    }
}
