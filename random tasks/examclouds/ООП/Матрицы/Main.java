/*Создать класс "Матрица". Класс должен иметь следующие поля:
1) двумерный массив вещественных чисел;
2) количество строк и столбцов в матрице.

Класс должен иметь следующие методы:
1) сложение с другой матрицей;
2) умножение на число;
3) вывод на печать;
 */

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы");
        Matrix matrix1 = new Matrix(scanner.nextInt());
        System.out.println("Введите размер матрицы");
        Matrix matrix2 = new Matrix(scanner.nextInt());

        matrix1.fill();
        matrix2.fill();
        //matrix1.showMatrix();

        try {                                      //если размеры матриц разные, возвращается 0
            matrix1.sum(matrix2).showMatrix();
        } catch (NullPointerException e){
            System.out.println("разные размеры матриц");
        }

        System.out.println("Введите число для умножения");
        float a = scanner.nextFloat();
        matrix1.multiplication(a);
        matrix1.showMatrix();
    }
}
