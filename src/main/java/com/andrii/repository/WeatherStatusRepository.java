package com.andrii.repository;

import com.andrii.models.WeatherStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherStatusRepository extends JpaRepository<WeatherStatus, Integer> {
}
