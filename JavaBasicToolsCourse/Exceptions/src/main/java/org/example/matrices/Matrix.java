package org.example.matrices;
import org.example.exceptions.MyArrayDataException;
import org.example.exceptions.MyArraySizeException;

public class Matrix {
    public static final int SIZE = 4;

    public static int getSumOfElements(String[][] matrix) throws MyArrayDataException, MyArraySizeException{
        if(matrix.length != SIZE){
            throw new MyArraySizeException(SIZE);
        }
        for (int i = 0; i < SIZE; i++) {
            if(matrix[i].length != SIZE){
                throw new MyArraySizeException(SIZE);
            }
        }

        int sum=0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] matrix = {{"4","4","4","4"},
                {"3","3","3","3"},
                {"2","2","2","2"},
                {"1","1","1","1"}};
        try {
            System.out.println(getSumOfElements(matrix));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }
}
