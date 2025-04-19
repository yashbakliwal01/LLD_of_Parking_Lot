package com.in.dto.vehicle;

import java.util.concurrent.atomic.AtomicInteger;

import com.in.enums.ParkingSpotEnum;

public abstract class Vehicle {

	private static final AtomicInteger x = new AtomicInteger(0);
	private int id;
	private ParkingSpotEnum parkingSpotEnum;
	
	public Vehicle(ParkingSpotEnum parkingSpotEnum) {
		id = x.incrementAndGet();
		this.parkingSpotEnum = parkingSpotEnum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParkingSpotEnum getParkingSpotEnum() {
		return parkingSpotEnum;
	}

	public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
		this.parkingSpotEnum = parkingSpotEnum;
	}
	
	
	
	
}
