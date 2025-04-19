package com.in.dto;

import java.util.HashMap;
import java.util.Map;

import com.in.enums.ParkingSpotEnum;

public class DisplayBoard {

	private static DisplayBoard displayBoard = null;
	private Map<ParkingSpotEnum, Integer> freeParkingSpots;
	
	public DisplayBoard() {
		this.freeParkingSpots = new HashMap<>();
	}
	
	public static DisplayBoard getInstance() {
		if(displayBoard==null) {
			displayBoard = new DisplayBoard();
		}
		return displayBoard;
	}
	
	public Map<ParkingSpotEnum, Integer> getFreeParkingSpots() {
        return freeParkingSpots;
    }
}
