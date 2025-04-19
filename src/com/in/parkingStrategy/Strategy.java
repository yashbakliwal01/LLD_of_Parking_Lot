package com.in.parkingStrategy;

import com.in.dto.parkingSpot.ParkingSpot;
import com.in.enums.ParkingSpotEnum;
import com.in.exceptions.SpotNotFoundException;

public interface Strategy {
	ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
