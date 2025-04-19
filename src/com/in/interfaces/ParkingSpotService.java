package com.in.interfaces;

import com.in.dto.parkingSpot.ParkingSpot;
import com.in.enums.ParkingSpotEnum;

public interface ParkingSpotService {
	ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor);
}
