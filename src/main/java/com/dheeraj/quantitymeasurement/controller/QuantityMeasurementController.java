package com.dheeraj.quantitymeasurement.controller;

import com.dheeraj.quantitymeasurement.dto.QuantityDTO;
import com.dheeraj.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.dheeraj.quantitymeasurement.service.IQuantityMeasurementService;
import com.dheeraj.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController() {
        this.service = new QuantityMeasurementServiceImpl(new QuantityMeasurementCacheRepository());
    }

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        return service.add(q1, q2);
    }

    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        return service.subtract(q1, q2);
    }

    public QuantityDTO convert(QuantityDTO q1, QuantityDTO q2) {
        return service.convert(q1, q2);
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return service.compare(q1, q2);
    }

    public double divide(QuantityDTO q1, QuantityDTO q2) {
        return service.divide(q1, q2);
    }
}