package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}