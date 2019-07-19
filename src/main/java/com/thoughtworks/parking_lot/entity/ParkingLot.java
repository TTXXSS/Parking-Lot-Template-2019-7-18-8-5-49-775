package com.thoughtworks.parking_lot.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParkingLot {

    @Id
    private String name;
    @Column
    private int capacity;
    @Column
    private String position;

    public ParkingLot(){

    }
    public ParkingLot(String name, int capacity, String position) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
