package com.thoughtworks.parking_lot;


import com.thoughtworks.parking_lot.controller.ParkingLotController;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotResipotory;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ParkingLotTest {
    @Autowired
    private ParkingLotResipotory parkingLotResipotory;

    @Autowired
    ParkingLotService parkingLotService;

    @Test
    public void should_return_1_size_when_call_add() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("东方海外");
        parkingLot.setCapacity(20);
        parkingLot.setPosition("东岸村");
        parkingLotResipotory.save(parkingLot);

        assertSame(1, parkingLotResipotory.findAll().size());
    }

    @Test
    public  void should_get_false_when_call_call_delete(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("11");
        parkingLot.setCapacity(10);
        parkingLot.setPosition("东岸村");
        parkingLotResipotory.save(parkingLot);
        parkingLotResipotory.deleteById("11");
        assertEquals(false,parkingLotResipotory.findById("11").isPresent());
    }

    @Test
    public void should_add_10_to_capacity_when_call_addPosition(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("10");
        parkingLot.setCapacity(10);
        parkingLot.setPosition("东岸村");
        parkingLotResipotory.save(parkingLot);
       // parkingLotService.addPosition(parkingLot.getName(),20);
        //System.out.println(parkingLotService.addPosition(parkingLot.getName(),20));
        assertSame(30,parkingLotService.addPosition(parkingLot.getName(),20).getCapacity());

    }

}
