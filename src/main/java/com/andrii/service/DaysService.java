package com.andrii.service;

import com.andrii.models.Days;
import com.andrii.repository.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaysService {
    @Autowired
    public DaysRepository daysRepository;

    public Days addDay(final Days days) {
        return daysRepository.save(days);
    }

    public Days updateDay(final Days days) {
        return daysRepository.save(days);
    }

    public List<Days> getDay() {
        return daysRepository.findAll();
    }

    public Days getDayId(final Integer id) {
        return daysRepository.findById(id).orElse(null);
    }

    public void deleteDaysById(Integer id){
        daysRepository.deleteById(id);
    }
}