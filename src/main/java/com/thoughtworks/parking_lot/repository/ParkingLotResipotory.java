package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ParkingLotResipotory extends JpaRepository<ParkingLot, String> {
    @Query(value = "SELECT * FROM ParkingLot limit 0,15", nativeQuery = true)
    public List<ParkingLot> findTopN();
}
