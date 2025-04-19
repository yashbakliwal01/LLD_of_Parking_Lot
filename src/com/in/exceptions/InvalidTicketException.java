package com.in.exceptions;

public class InvalidTicketException extends Exception{
    public InvalidTicketException(String message){
        super(message);
    }
}