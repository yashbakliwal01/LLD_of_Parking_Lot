package com.in.services;

import com.in.dto.parkingSpot.ParkingSpot;
import com.in.enums.ParkingSpotEnum;
import com.in.interfaces.DisplayService;
import com.in.interfaces.ParkingSpotService;

public class ParkingSpotServiceImpl implements ParkingSpotService{

	@Override
	public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {
		DisplayService displayService = new DisplayServiceImpl();
		
		return null;
	}

}
