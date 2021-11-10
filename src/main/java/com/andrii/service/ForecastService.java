package com.andrii.service;

import com.andrii.models.Forecast;
import com.andrii.repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastService {
    @Autowired
    public ForecastRepository forecastRepository;

    public Forecast addForecast(final Forecast forecast) {
        return forecastRepository.save(forecast);
    }

    public Forecast updateForecast(final Forecast forecast) {
        return forecastRepository.save(forecast);
    }

    public List<Forecast> getForecast() {
        return forecastRepository.findAll();
    }

    public Forecast getForecastId(final Integer id) {
        return forecastRepository.findById(id).orElse(null);
    }

    public void deleteForecastById(Integer id){
        forecastRepository.deleteById(id);
    }
}
