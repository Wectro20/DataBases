package com.andrii.repository;

import com.andrii.models.WeatherWarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherWarningRepository extends JpaRepository<WeatherWarning, Integer> {
}
