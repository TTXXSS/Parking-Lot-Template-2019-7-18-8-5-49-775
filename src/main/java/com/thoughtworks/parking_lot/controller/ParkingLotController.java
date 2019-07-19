package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.thoughtworks.parking_lot.repository.ParkingLotResipotory;

import java.util.List;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {


    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> get() {
        return parkingLotService.get();

    }

    @GetMapping("/11/{id}")
    public ParkingLot getParkingLotById(@PathVariable String name) {
        return parkingLotService.getParkingLotById(name);
    }

    @PostMapping()
    public ParkingLot add(@RequestBody ParkingLot parkingLot) {

        return parkingLotService.add(parkingLot);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        parkingLotService.delete(id);
    }

    @GetMapping("/12")
    public List<ParkingLot> getParkingLotFromOneToFifteen() {
        return parkingLotService.getParkingLotFromOneToFifteen();
    }

    @PutMapping("/{length}")
    public ParkingLot addCapacity(@RequestBody String name, @PathVariable int length) {
        return parkingLotService.addPosition(name, length);
    }
}
