package com.in.services;

import java.util.ArrayList;
import java.util.List;

import com.in.dto.ParkingEvent;
import com.in.dto.ParkingLot;
import com.in.dto.ParkingTicket;
import com.in.dto.parkingSpot.ParkingSpot;
import com.in.dto.parkingSpot.spotDecorator.Wash;
import com.in.dto.vehicle.Vehicle;
import com.in.enums.ParkingEventType;
import com.in.enums.ParkingSpotEnum;
import com.in.exceptions.InvalidTicketException;
import com.in.interfaces.DisplayService;
import com.in.interfaces.Observer;
import com.in.interfaces.ParkingService;
import com.in.parkingStrategy.Strategy;

public class ParkingServiceImpl implements ParkingService{

	Strategy parkingStrategy;
	ParkingLot parkingLot;
	DisplayService displayService;	
	private List<Observer> observers;
	
	
	
	public ParkingServiceImpl(Strategy parkingStrategy) {
		super();
		this.parkingStrategy = parkingStrategy;
		parkingLot=ParkingLot.getInstance();
		displayService=new DisplayServiceImpl();
		observers = new ArrayList<>();
	}

	@Override
	public ParkingTicket entry(Vehicle vehicle) {
		ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
		List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
		List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);
		try {
			ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
			if(parkingSpot.isFree()) {
				synchronized (parkingSpot) {
					if(parkingSpot.isFree()) {
						parkingSpot.setFree(false);
						freeParkingSpots.remove(parkingSpot);
						occupiedParkingSpots.add(parkingSpot);
						ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
						
						ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY, parkingSpotEnum);
						notifyAllObservers(parkingEvent);
						return parkingTicket;
					}
					entry(vehicle);
				}
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public void notifyAllObservers(ParkingEvent parkingEvent) {
		for(Observer observer: observers) {
			observer.update(parkingEvent);
		}
	}
	
	private void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	private void addParkingSpotInFreeList(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
	}
	
	public void addWash(ParkingTicket parkingTicket) {
		parkingTicket.setParkingSpot(new Wash(parkingTicket.getParkingSpot()));
	}

	@Override
	public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
		if(parkingTicket.getVehicle().equals(vehicle)) {
			ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
			int amount = parkingSpot.getAmount();
			parkingSpot.setFree(true);
			parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
			addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);
		
			
			ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT, vehicle.getParkingSpotEnum());
			notifyAllObservers(parkingEvent);
			return amount;
		}else {
			throw new InvalidTicketException("This is an Invalid Ticket!!!");
		}
	}
}
