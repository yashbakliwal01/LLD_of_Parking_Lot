package com.in.parkingStrategy;

import java.util.List;

import com.in.dto.ParkingLot;
import com.in.dto.parkingSpot.ParkingSpot;
import com.in.enums.ParkingSpotEnum;
import com.in.exceptions.SpotNotFoundException;

public class NearestFirstParkingStrategy implements Strategy{

	
	@Override
	public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
		List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
		if(parkingSpots.size()==0) {
			throw new SpotNotFoundException("Spot not found in nearest first strategy");
		}
		return parkingSpots.get(0);
	}

}
