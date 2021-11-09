package com.andrii.controllers;


import com.andrii.models.City;
import com.andrii.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.andrii.exceptions.ConferenceNotFoundException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/city")
public class CityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<City> getCity(@PathVariable(name = "id") Integer id) {
        if (cityService.getCityId(id) == null) {
            LOGGER.info("Can't update city with non-existing id" + id);
            throw new ConferenceNotFoundException("City with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<City>(cityService.getCityId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> getCity() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<City>>(cityService.getCity(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@Valid @RequestBody City city) {
        LOGGER.info("Success added city");
        return new ResponseEntity<City>(cityService.addCity(city), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity(@PathVariable("id")final int id, @Valid @RequestBody final City city) {
        if (cityService.getCityId(id) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("City with id: " + id + " not found");
        }
        LOGGER.info("Updated an item with id: " + id);
        city.setId(id);
        return new ResponseEntity<City>(cityService.updateCity(city), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable("id") Integer id) {
        if (cityService.getCityId(id) == null) {
            LOGGER.info("Can't delete City ");
            throw new ConferenceNotFoundException("City with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted city with id: " +id);
        cityService.deleteCityById(id);
        return ResponseEntity.noContent().build();
    }
}
