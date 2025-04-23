package com.in.services;

import com.in.dto.DisplayBoard;
import com.in.dto.ParkingEvent;
import com.in.enums.ParkingEventType;
import com.in.enums.ParkingSpotEnum;
import com.in.interfaces.DisplayService;
import com.in.interfaces.Observer;

public class DisplayServiceImpl implements DisplayService, Observer{

	@Override
	public void update(ParkingEvent event) {
		
		int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
		int change =0;
		
		if(event.getEventType().equals(ParkingEventType.ENTRY)) {
			change = -1;
		}
		else {
			change = 1;
		}
		
		int newCount = change + currentCount;
		DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(), newCount);
		//return;
	}

	@Override
	public void update(ParkingSpotEnum parkingSpotEnum, int change) {

		Integer currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
		if(currentCount == null) currentCount=0;
		int newCount = currentCount+change;
		DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);
	}

}
