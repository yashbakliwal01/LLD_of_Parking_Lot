package com.in.dto.vehicle;

import com.in.enums.ParkingSpotEnum;

public class Car extends Vehicle{

	public Car(ParkingSpotEnum parkingSpotEnum) {
		super(ParkingSpotEnum.COMPACT);
	}

}
