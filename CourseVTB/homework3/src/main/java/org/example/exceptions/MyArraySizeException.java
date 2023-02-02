package org.example.exceptions;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(){
        super("Invalid array size");
    }
}
