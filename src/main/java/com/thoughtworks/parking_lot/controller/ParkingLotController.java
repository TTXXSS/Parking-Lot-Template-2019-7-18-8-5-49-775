package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.thoughtworks.parking_lot.repository.ParkingLotResipotory;

import java.util.List;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {

    @Autowired
    ParkingLotResipotory parkingLotResipotory;

    @GetMapping
    public List<ParkingLot> get() {
        return parkingLotResipotory.findAll();
    }

    @GetMapping("/11/{id}")
    public ParkingLot getParkingLotById(@PathVariable String name) {
        return parkingLotResipotory.findById(name).get();
    }

    @PostMapping()
    public ParkingLot add(@RequestBody ParkingLot parkingLot) {

        return parkingLotResipotory.save(parkingLot);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        parkingLotResipotory.deleteById(id);
    }
    @GetMapping("/12")
    public List<ParkingLot> getParkingLotFromOneToFifteen(){
      return   parkingLotResipotory.findAll();
    }

}
