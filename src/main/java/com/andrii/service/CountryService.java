package com.andrii.service;

import com.andrii.models.Country;
import com.andrii.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    public CountryRepository countryRepository;

    public Country addCountry(final Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(final Country country) {
        return countryRepository.save(country);
    }

    public List<Country> getCountry() {
        return countryRepository.findAll();
    }

    public Country getCountryId(final Integer id) {
        return countryRepository.findById(id).orElse(null);
    }

    public void deleteCountryById(Integer id){
        countryRepository.deleteById(id);
    }
}
