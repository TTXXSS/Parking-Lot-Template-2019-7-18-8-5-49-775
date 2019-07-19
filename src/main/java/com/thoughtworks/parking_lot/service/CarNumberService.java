package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.controller.CarNumberController;
import com.thoughtworks.parking_lot.entity.CarNumber;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotResipotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/carnumber")
public class CarNumberService {
    @Autowired
    CarNumberController carNumberController;

    @Autowired
    ParkingLotResipotory parkingLotResipotory;

    @PostMapping("/{name}")
    public void add(@PathVariable String parkingLotName){
        System.out.println(parkingLotName);

        ParkingLot parkingLot;
        parkingLotResipotory.findById("61");

        if(parkingLotResipotory.findById(parkingLotName).isPresent()) {
            parkingLot  =parkingLotResipotory.findById(parkingLotName).get();
            //int capacity =parkingLot.getCapacity();
           System.out.println(parkingLot.getName());
        }

    }

    @GetMapping
    public List<ParkingLot> get(){
        System.out.println("test");
        return parkingLotResipotory.findAll();
    }
}
