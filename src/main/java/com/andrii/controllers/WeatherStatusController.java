package com.andrii.controllers;

import com.andrii.dto.WeatherStatusDto;
import com.andrii.exceptions.ConferenceNotFoundException;
import com.andrii.models.Forecast;
import com.andrii.models.WeatherStatus;
import com.andrii.service.WeatherStatusService;
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
@RequestMapping(path = "/ws")
public class WeatherStatusController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private WeatherStatusService weatherStatusService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<WeatherStatusDto> getWeatherStatus(@PathVariable(name = "id") Integer id) {
        if (weatherStatusService.getWeatherStatusId(id) == null) {
            LOGGER.info("Can't update weatherStatus with non-existing id" + id);
            throw new ConferenceNotFoundException("WeatherStatus with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        WeatherStatus weatherStatus = weatherStatusService.getWeatherStatusId(id);
        return new ResponseEntity<WeatherStatusDto>(new WeatherStatusDto(weatherStatus), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WeatherStatusDto>> getWeatherStatus() {
        LOGGER.info("Successfully gave an objects");
        List<WeatherStatus> weatherStatuses = weatherStatusService.getWeatherStatus();
        List<WeatherStatusDto> weatherStatusDtos = new ArrayList<>();
        for (WeatherStatus weatherStatus : weatherStatuses) {
            WeatherStatusDto weatherStatusDto = new WeatherStatusDto(weatherStatus);
            weatherStatusDtos.add(weatherStatusDto);
        }
        return new ResponseEntity<List<WeatherStatusDto>>(weatherStatusDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WeatherStatusDto> createWeatherStatus(@Valid @RequestBody WeatherStatus weatherStatus) {
        LOGGER.info("Success added weatherStatus");
        weatherStatusService.addWeatherStatus(weatherStatus);
        return new ResponseEntity<WeatherStatusDto>(new WeatherStatusDto(weatherStatus), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherStatusDto> updateWeatherStatus(@PathVariable("id")final int id, @Valid @RequestBody final WeatherStatus weatherStatus) {
        if (weatherStatusService.getWeatherStatusId(id) == null) {
            LOGGER.info("Can't update weatherStatus without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("WeatherStatus with id: " + id + " not found");
        }
        LOGGER.info("Updated an item with id: " + id);
        weatherStatus.setId(id);
        weatherStatusService.updateWeatherStatus(weatherStatus);
        return new ResponseEntity<WeatherStatusDto>(new WeatherStatusDto(weatherStatus), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WeatherStatus> deleteWeatherStatus(@PathVariable("id") Integer id) {
        if (weatherStatusService.getWeatherStatusId(id) == null) {
            LOGGER.info("Can't delete weatherStatus ");
            throw new ConferenceNotFoundException("WeatherStatus with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted weatherStatus with id: " +id);
        weatherStatusService.deleteWeatherStatusById(id);
        return ResponseEntity.noContent().build();
    }
}
