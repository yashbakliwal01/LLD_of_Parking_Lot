package com.in.interfaces;

import com.in.dto.ParkingTicket;
import com.in.dto.vehicle.Vehicle;
import com.in.exceptions.InvalidTicketException;

public interface ParkingService {
	ParkingTicket entry(Vehicle vehicle);
	int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
