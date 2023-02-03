package org.example.exceptions;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int row, int column){
        super("Invalid array data in \n" + "row = " + row + " column = " + column);
    }
}
