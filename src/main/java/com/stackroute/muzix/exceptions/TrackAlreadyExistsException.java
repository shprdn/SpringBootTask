package com.stackroute.muzix.exceptions;

public class TrackAlreadyExistsException extends Exception{

    //message to print when exception occurs
    private String message;

    //constructor
    public TrackAlreadyExistsException()
    {

    }

    public TrackAlreadyExistsException(String message)
    {
        super(message);
        this.message = message;
    }
}
