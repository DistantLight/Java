package org.example.exceptions;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int size){
        super("Invalid array size. Size should be " + size);
    }
}
