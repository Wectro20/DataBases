package com.andrii.service;

import com.andrii.models.WeatherWarning;
import com.andrii.repository.WeatherWarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherWarningService {
    @Autowired
    public WeatherWarningRepository weatherWarningRepository;

    public WeatherWarning addWeatherWarning(final WeatherWarning weatherWarning) {
        return weatherWarningRepository.save(weatherWarning);
    }

    public WeatherWarning updateWeatherWarning(final WeatherWarning weatherWarning) {
        return weatherWarningRepository.save(weatherWarning);
    }

    public List<WeatherWarning> getWeatherWarning() {
        return weatherWarningRepository.findAll();
    }

    public WeatherWarning getWeatherWarningId(final Integer id) {
        return weatherWarningRepository.findById(id).orElse(null);
    }

    public void deleteWeatherWarningById(Integer id){
        weatherWarningRepository.deleteById(id);
    }
}
