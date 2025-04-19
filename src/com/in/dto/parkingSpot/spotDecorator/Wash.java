package com.in.dto.parkingSpot.spotDecorator;

import com.in.dto.parkingSpot.ParkingSpot;

public class Wash extends SpotDecorator{

	public Wash(ParkingSpot parkingSpot) {
		super(parkingSpot);
	}

	@Override
	public int cost(int parkingHours) {
		return parkingSpot.cost(parkingHours)+250;
	}

	
}
