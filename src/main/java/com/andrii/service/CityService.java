package com.andrii.service;

import com.andrii.models.City;
import com.andrii.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class CityService{

    @Autowired
    public CityRepository cityRepository;

    public City addCity(final City city) {
        return cityRepository.save(city);
    }

    public City updateCity(final City city) {
        return cityRepository.save(city);
    }

    public List<City> getCity() {
        return cityRepository.findAll();
    }

    public City getCityId(final Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    public void deleteCityById(Integer id){
        cityRepository.deleteById(id);
    }
}
