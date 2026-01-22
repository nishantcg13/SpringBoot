package com.nishant.blog_app_apis.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName ;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException( String resourceName ,String fieldName, long fieldValue) {
        super(String.format("%s not found with this name %s : %d",resourceName,fieldName,fieldValue));
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
        this.resourceName = resourceName;
    }
}
