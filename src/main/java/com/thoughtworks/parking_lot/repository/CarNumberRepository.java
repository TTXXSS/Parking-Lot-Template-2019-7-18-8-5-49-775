package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.CarNumber;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarNumberRepository extends JpaRepository<CarNumber,Integer> {
}
