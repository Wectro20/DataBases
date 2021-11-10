package com.andrii.controllers;

import com.andrii.dto.CityDto;
import com.andrii.dto.ForecastDto;
import com.andrii.exceptions.ConferenceNotFoundException;
import com.andrii.models.City;
import com.andrii.models.Forecast;
import com.andrii.service.ForecastService;
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
@RequestMapping(path = "/forecast")
public class ForecastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private ForecastService forecastService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ForecastDto> getForecast(@PathVariable(name = "id") Integer id) {
        if (forecastService.getForecastId(id) == null) {
            LOGGER.info("Can't update forecast with non-existing id" + id);
            throw new ConferenceNotFoundException("Forecast with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Forecast forecast = forecastService.getForecastId(id);
        return new ResponseEntity<ForecastDto>(new ForecastDto(forecast), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ForecastDto>> getForecast() {
        LOGGER.info("Successfully gave an objects");
        List<Forecast> forecasts = forecastService.getForecast();
        List<ForecastDto> forecastDtos = new ArrayList<>();
        for (Forecast forecast : forecasts) {
            ForecastDto forecastDto = new ForecastDto(forecast);
            forecastDtos.add(forecastDto);
        }
        return new ResponseEntity<List<ForecastDto>>(forecastDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ForecastDto> createForecast(@Valid @RequestBody Forecast forecast) {
        LOGGER.info("Success added forecast");
        forecastService.addForecast(forecast);
        return new ResponseEntity<ForecastDto>(new ForecastDto(forecast), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ForecastDto> updateForecast(@PathVariable("id")final int id, @Valid @RequestBody final Forecast forecast) {
        if (forecastService.getForecastId(id) == null) {
            LOGGER.info("Can't update Forecast without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("City with id: " + id + " not found");
        }
        LOGGER.info("Updated an item with id: " + id);
        forecast.setId(id);
        forecastService.updateForecast(forecast);
        return new ResponseEntity<ForecastDto>(new ForecastDto(forecast), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Forecast> deleteForecast(@PathVariable("id") Integer id) {
        if (forecastService.getForecastId(id) == null) {
            LOGGER.info("Can't delete Forecast ");
            throw new ConferenceNotFoundException("Forecast with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted forecast with id: " +id);
        forecastService.deleteForecastById(id);
        return ResponseEntity.noContent().build();
    }
}
