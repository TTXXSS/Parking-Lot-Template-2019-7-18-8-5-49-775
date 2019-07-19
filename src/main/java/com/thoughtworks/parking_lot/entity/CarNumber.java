package com.thoughtworks.parking_lot.entity;

import javax.persistence.*;

@Entity
public class CarNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String ParkingLot;
    @Column(unique = true)
    private int carId;
    @Column
    private String StartTime;
    @Column
    private String endTime;

    public CarNumber(){

    }
    public CarNumber(int id, String parkingLot, int carId, String startTime, String endTime) {
        this.id = id;
        ParkingLot = parkingLot;
        this.carId = carId;
        StartTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingLot() {
        return ParkingLot;
    }

    public void setParkingLot(String parkingLot) {
        ParkingLot = parkingLot;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
