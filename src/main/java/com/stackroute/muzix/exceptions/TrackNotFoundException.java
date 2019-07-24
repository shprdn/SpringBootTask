package com.stackroute.muzix.exceptions;

public class TrackNotFoundException extends Exception {

    //message to print when exception occurs
    private String message;

    //constructor
    public TrackNotFoundException()
    {

    }

    public TrackNotFoundException(String message)
    {
        super(message);
        this.message = message;
    }
}
