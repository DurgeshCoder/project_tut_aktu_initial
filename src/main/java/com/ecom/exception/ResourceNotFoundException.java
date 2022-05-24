package com.ecom.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

        super("resource not found!!");

    }

    public ResourceNotFoundException(String user, String username, String email) {

        super(user + " with " + username + " : " + email + " not found !!");

    }
}
