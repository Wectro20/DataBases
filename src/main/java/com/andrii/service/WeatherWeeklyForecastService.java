package com.andrii.service;

import com.andrii.models.WeatherWeeklyForecast;
import com.andrii.repository.WeatherWeeklyForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherWeeklyForecastService {
    @Autowired
    public WeatherWeeklyForecastRepository weatherWeeklyForecastRepository;

    public WeatherWeeklyForecast addWeatherWeeklyForecast(final WeatherWeeklyForecast weatherWeeklyForecast) {
        return weatherWeeklyForecastRepository.save(weatherWeeklyForecast);
    }

    public WeatherWeeklyForecast updateWeatherWeeklyForecast(final WeatherWeeklyForecast weatherWeeklyForecast) {
        return weatherWeeklyForecastRepository.save(weatherWeeklyForecast);
    }

    public List<WeatherWeeklyForecast> getWeatherWeeklyForecast() {
        return weatherWeeklyForecastRepository.findAll();
    }

    public WeatherWeeklyForecast getWeatherWeeklyForecast(final Integer id) {
        return weatherWeeklyForecastRepository.findById(id).orElse(null);
    }

    public void deleteWeatherWeeklyForecastById(Integer id){
        weatherWeeklyForecastRepository.deleteById(id);
    }
}
