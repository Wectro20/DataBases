package com.andrii.controllers;

import com.andrii.exceptions.ConferenceNotFoundException;
import com.andrii.models.WeatherWeeklyForecast;
import com.andrii.service.WeatherWeeklyForecastService;
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
@RequestMapping(path = "/wwf")
public class WeatherWeeklyForecastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private WeatherWeeklyForecastService weatherWeeklyForecastService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<WeatherWeeklyForecast> getWeatherWeeklyForecast(@PathVariable(name = "id") Integer id) {
        if (weatherWeeklyForecastService.getWeatherWeeklyForecast(id) == null) {
            LOGGER.info("Can't update WeatherWeeklyForecast with non-existing id" + id);
            throw new ConferenceNotFoundException("WeatherWeeklyForecast with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<WeatherWeeklyForecast>(weatherWeeklyForecastService.getWeatherWeeklyForecast(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WeatherWeeklyForecast>> getWeatherWeeklyForecast() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<WeatherWeeklyForecast>>(weatherWeeklyForecastService.getWeatherWeeklyForecast(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WeatherWeeklyForecast> createWeatherWeeklyForecast(@Valid @RequestBody WeatherWeeklyForecast weatherWeeklyForecast) {
        LOGGER.info("Success added city");
        return new ResponseEntity<WeatherWeeklyForecast>(weatherWeeklyForecastService.addWeatherWeeklyForecast(weatherWeeklyForecast), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherWeeklyForecast> updateWeatherWeeklyForecast(@PathVariable("id")final int id, @Valid @RequestBody final WeatherWeeklyForecast weatherWeeklyForecast) {
        if (weatherWeeklyForecastService.getWeatherWeeklyForecast(id) == null) {
            LOGGER.info("Can't update WeatherWeeklyForecast without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("WeatherWeeklyForecast with id: " + id + " not found");
        }
        LOGGER.info("Updated an city with id: " + id);
        weatherWeeklyForecast.setId(id);
        return new ResponseEntity<WeatherWeeklyForecast>(weatherWeeklyForecastService.updateWeatherWeeklyForecast(weatherWeeklyForecast), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WeatherWeeklyForecast> deleteWeatherWeeklyForecast(@PathVariable("id") Integer id) {
        if (weatherWeeklyForecastService.getWeatherWeeklyForecast(id) == null) {
            LOGGER.info("Can't delete City ");
            throw new ConferenceNotFoundException("WeatherWeeklyForecast with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted WeatherWeeklyForecast with id: " +id);
        weatherWeeklyForecastService.deleteWeatherWeeklyForecastById(id);
        return ResponseEntity.noContent().build();
    }
}
