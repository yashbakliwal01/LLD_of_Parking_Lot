package com.in.dto.vehicle;

import com.in.enums.ParkingSpotEnum;

public class Truck extends Vehicle{

	public Truck(ParkingSpotEnum parkingSpotEnum) {
		super(ParkingSpotEnum.LARGE);
	}

}
