package com.in.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import com.in.dto.parkingSpot.ParkingSpot;
import com.in.dto.vehicle.Vehicle;

public class ParkingTicket {
	private static final AtomicInteger x = new AtomicInteger(0);
	private int id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime timestamp;
    
	public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
		id = x.incrementAndGet();
		this.vehicle = vehicle;
		this.parkingSpot = parkingSpot;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
    public int getParkingHours(LocalDateTime exitTme) {
    	return (int) Duration.between(this.timestamp, exitTme).toHours();
    }
    
    
}
