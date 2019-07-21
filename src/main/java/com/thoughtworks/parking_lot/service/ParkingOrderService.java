package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotResipotory;
import com.thoughtworks.parking_lot.repository.ParkingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingOrderService {
    @Autowired
    ParkingOrderRepository parkingOrderRepository;

    @Autowired
    ParkingLotResipotory parkingLotResipotory;

    public ParkingOrder saveParkingOrder(String carId,String parkingLotName){
        ParkingLot parkingLot = parkingLotResipotory.findById(parkingLotName).get();

        parkingLot.setCapacity(parkingLot.getCapacity()-1);

        ParkingOrder parkingOrder = new ParkingOrder();
        parkingOrder.setStarttime(new Date());
        parkingOrder.setEndTime(new Date());
        parkingOrder.setCarId(carId);
        parkingOrder.setParkingLotName(parkingLotName);
        parkingOrder.setState("open");

        List<ParkingOrder> list = new ArrayList<>();
        list.add(parkingOrder);
        parkingLot.setParkingOrders(list);
        parkingLotResipotory.save(parkingLot);
        return  parkingOrderRepository.save(parkingOrder);
    }

    public boolean isParkingLotEmpty(String parkingLotName){
       Optional<ParkingLot> optional= parkingLotResipotory.findById(parkingLotName);
       if(optional.isPresent()) {
           ParkingLot parkingLot = optional.get();
           if(parkingLot.getCapacity()>0)
           return true;
       }
       return false;
    }

    public List<ParkingOrder> getOrder() {
        return parkingOrderRepository.findAll();
    }

    public ParkingOrder changeOrder(String carId) {
        List<ParkingOrder> list = parkingOrderRepository.findAll();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getCarId().equals(carId)){
                list.get(i).setState("close");
                list.get(i).setParkingLotName(null);
                list.get(i).setEndTime(new Date());
             return    parkingOrderRepository.save(list.get(i));
            }
        }
        return  null;
    }
}
