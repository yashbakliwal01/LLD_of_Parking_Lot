package com.in.services;

import java.lang.reflect.InvocationTargetException;

import com.in.dto.ParkingLot;
import com.in.dto.parkingSpot.ParkingSpot;
import com.in.enums.ParkingSpotEnum;
import com.in.interfaces.DisplayService;
import com.in.interfaces.ParkingSpotService;

public class ParkingSpotServiceImpl implements ParkingSpotService{

	@Override
	public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {
		try {
			DisplayService displayService = new DisplayServiceImpl();
			ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
			ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
			displayService.update(parkingSpotEnum, 1);
			return parkingSpot;
		}catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
