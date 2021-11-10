package com.andrii.repository;

import com.andrii.models.City;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
