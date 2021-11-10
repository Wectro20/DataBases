package com.andrii.controllers;

import com.andrii.exceptions.ConferenceNotFoundException;
import com.andrii.models.WeatherWarning;
import com.andrii.service.WeatherWarningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/ww")
public class WeatherWarningController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private WeatherWarningService weatherWarningService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<WeatherWarning> getWeatherWarning(@PathVariable(name = "id") Integer id) {
        if (weatherWarningService.getWeatherWarningId(id) == null) {
            LOGGER.info("Can't update WeatherWarning with non-existing id" + id);
            throw new ConferenceNotFoundException("WeatherWarning with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<WeatherWarning>(weatherWarningService.getWeatherWarningId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WeatherWarning>> getWeatherWarning() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<WeatherWarning>>(weatherWarningService.getWeatherWarning(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WeatherWarning> createWeatherWarning(@Valid @RequestBody WeatherWarning weatherWarning) {
        LOGGER.info("Success added WeatherWarning");
        return new ResponseEntity<WeatherWarning>(weatherWarningService.addWeatherWarning(weatherWarning), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherWarning> updateWeatherWarning(@PathVariable("id")final int id, @Valid @RequestBody final WeatherWarning weatherWarning) {
        if (weatherWarningService.getWeatherWarningId(id) == null) {
            LOGGER.info("Can't update WeatherWarning without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("WeatherWarning with id: " + id + " not found");
        }
        LOGGER.info("Updated an WeatherWarning with id: " + id);
        weatherWarning.setId(id);
        return new ResponseEntity<WeatherWarning>(weatherWarningService.updateWeatherWarning(weatherWarning), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WeatherWarning> deleteWeatherWarning(@PathVariable("id") Integer id) {
        if (weatherWarningService.getWeatherWarningId(id) == null) {
            LOGGER.info("Can't delete WeatherWarning ");
            throw new ConferenceNotFoundException("WeatherWarning with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted WeatherWarning with id: " +id);
        weatherWarningService.deleteWeatherWarningById(id);
        return ResponseEntity.noContent().build();
    }
}
