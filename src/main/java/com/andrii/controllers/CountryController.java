package com.andrii.controllers;
import com.andrii.dto.CountryDto;
import com.andrii.exceptions.ConferenceNotFoundException;
import com.andrii.models.Country;
import com.andrii.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/country")
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable(name = "id") Integer id) {
        if (countryService.getCountryId(id) == null) {
            LOGGER.info("Can't update country with non-existing id" + id);
            throw new ConferenceNotFoundException("Country with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Country country = countryService.getCountryId(id);
        return new ResponseEntity<CountryDto>(new CountryDto(country), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getCountry() {
        LOGGER.info("Successfully gave an objects");
        List<Country> countries = countryService.getCountry();
        List<CountryDto> countryDtos = new ArrayList<>();
        for (Country country:countries) {
            CountryDto countryDto = new CountryDto(country);
            countryDtos.add(countryDto);
        }
        return new ResponseEntity<List<CountryDto>>(countryDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@Valid @RequestBody Country country) {
        LOGGER.info("Success added country");
        countryService.addCountry(country);
        return new ResponseEntity<CountryDto>(new CountryDto(country), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDto> updateCountry(@PathVariable("id")final int id, @Valid @RequestBody final Country country) {
        if (countryService.getCountryId(id) == null) {
            LOGGER.info("Can't update country without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("Country with id: " + id + " not found");
        }
        LOGGER.info("Updated an country with id: " + id);
        country.setId(id);
        countryService.updateCountry(country);
        return new ResponseEntity<CountryDto>(new CountryDto(country), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable("id") Integer id) {
        if (countryService.getCountryId(id) == null) {
            LOGGER.info("Can't delete Country ");
            throw new ConferenceNotFoundException("Country with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted city with id: " +id);
        countryService.deleteCountryById(id);
        return ResponseEntity.noContent().build();
    }
}
