package com.andrii.service;

import com.andrii.models.WeatherStatus;
import com.andrii.repository.WeatherStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherStatusService {
    @Autowired
    public WeatherStatusRepository weatherStatusRepository;

    public WeatherStatus addWeatherStatus(final WeatherStatus weatherStatus) {
        return weatherStatusRepository.save(weatherStatus);
    }

    public WeatherStatus updateWeatherStatus(final WeatherStatus weatherStatus) {
        return weatherStatusRepository.save(weatherStatus);
    }

    public List<WeatherStatus> getWeatherStatus() {
        return weatherStatusRepository.findAll();
    }

    public WeatherStatus getWeatherStatusId(final Integer id) {
        return weatherStatusRepository.findById(id).orElse(null);
    }

    public void deleteWeatherStatusById(Integer id){
        weatherStatusRepository.deleteById(id);
    }
}
