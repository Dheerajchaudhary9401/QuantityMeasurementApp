package com.dheeraj.quantitymeasurement.repository;

import com.dheeraj.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {
	
	void save(QuantityMeasurementEntity entity);
	
}