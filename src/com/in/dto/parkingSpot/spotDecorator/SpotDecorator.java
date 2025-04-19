package com.in.dto.parkingSpot.spotDecorator;

import com.in.dto.parkingSpot.ParkingSpot;


//decorate a ParkingSpot with additional features without modifying the original ParkingSpot classes
public abstract class SpotDecorator extends ParkingSpot{
	
	protected ParkingSpot parkingSpot;
	
	public SpotDecorator(ParkingSpot parkingSpot) {
		this.parkingSpot=parkingSpot;
	}

}
