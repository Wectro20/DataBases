package com.andrii.controllers;

import com.andrii.dto.DaysDto;
import com.andrii.exceptions.ConferenceNotFoundException;
import com.andrii.models.Days;
import com.andrii.service.DaysService;
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
@RequestMapping(path = "/days")
public class DaysController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private DaysService daysService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<DaysDto> getDays(@PathVariable(name = "id") Integer id) {
        if (daysService.getDayId(id) == null) {
            LOGGER.info("Can't update day with non-existing id" + id);
            throw new ConferenceNotFoundException("Day with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Days days = daysService.getDayId(id);
        return new ResponseEntity<DaysDto>(new DaysDto(days), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DaysDto>> getDays() {
        LOGGER.info("Successfully gave an objects");
        List<Days> days1 = daysService.getDay();
        List<DaysDto> daysDtos = new ArrayList<>();
        for (Days days2: days1) {
            DaysDto daysDto = new DaysDto(days2);
            daysDtos.add(daysDto);
        }
        return new ResponseEntity<List<DaysDto>>(daysDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DaysDto> createDays(@Valid @RequestBody Days day) {
        LOGGER.info("Success added day");
        daysService.addDay(day);
        return new ResponseEntity<DaysDto>(new DaysDto(day), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DaysDto> updateDays(@PathVariable("id")final int id, @Valid @RequestBody final Days day) {
        if (daysService.getDayId(id) == null) {
            LOGGER.info("Can't update Day without id - null value was passed instead of it");
            throw new ConferenceNotFoundException("Day with id: " + id + " not found");
        }
        LOGGER.info("Updated an day with id: " + id);
        day.setId(id);
        daysService.updateDay(day);
        return new ResponseEntity<DaysDto>(new DaysDto(day), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Days> deleteDays(@PathVariable("id") Integer id) {
        if (daysService.getDayId(id) == null) {
            LOGGER.info("Can't delete Day ");
            throw new ConferenceNotFoundException("Day with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted day with id: " +id);
        daysService.deleteDaysById(id);
        return ResponseEntity.noContent().build();
    }
}
