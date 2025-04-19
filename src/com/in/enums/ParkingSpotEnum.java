package com.in.enums;

import com.in.dto.parkingSpot.Compact;
import com.in.dto.parkingSpot.Large;
import com.in.dto.parkingSpot.Mini;

public enum ParkingSpotEnum {

	COMPACT(Compact.class),
	MINI(Mini.class),
	LARGE(Large.class);
	
	private Class parkingSpot;

	
	private ParkingSpotEnum(Class parkingSpot) {
		this.parkingSpot = parkingSpot;
	}


	public Class getParkingSpot() {
		return parkingSpot;
	}

	
	
}
