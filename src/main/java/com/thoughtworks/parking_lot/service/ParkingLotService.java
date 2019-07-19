package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotResipotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotResipotory parkingLotResipotory;

    public List<ParkingLot> get() {
        //parkingLotResipotory.findAll();
        return parkingLotResipotory.findAll();
    }

    public ParkingLot getParkingLotById(String name) {
        return parkingLotResipotory.findById(name).get();
    }

    public ParkingLot add(ParkingLot parkingLot) {

        return parkingLotResipotory.save(parkingLot);
    }

    public void delete( String id) {
        parkingLotResipotory.deleteById(id);
    }
    public List<ParkingLot> getParkingLotFromOneToFifteen(){
        return   parkingLotResipotory.findAll();
    }
    public ParkingLot addPosition(String name,int lengthOfAdd){
        System.out.println(name);
        ParkingLot list;
        if(parkingLotResipotory.findById(name).isPresent()) {
            list = parkingLotResipotory.findById(name).get();
            list.setCapacity(list.getCapacity() + lengthOfAdd);
            return parkingLotResipotory.save(list);
        }
        return null;
    }
}
