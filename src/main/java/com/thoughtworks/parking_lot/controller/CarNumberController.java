package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.repository.CarNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarNumberController {

    @Autowired
    CarNumberRepository carNumberRepository;

}
