package com.project.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

        super("resource not found!!");

    }

    public ResourceNotFoundException(String resource, String resourceId) {

        super(resource + " with " + resourceId + " not found on server !!");

    }
}
