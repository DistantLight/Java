import java.util.Scanner;

public class Matrix {

    private float [][] arr;
    private int quantity;

    Scanner scanner =new Scanner(System.in);

    Matrix(int quantity) {
        this.quantity = quantity;
        this.arr = new float[quantity][quantity];
    }

    void fill(){
        for(int i=0; i<quantity; i++){
            for (int j=0; j<quantity; j++){
                System.out.println("Введите элемент номер " + j +" в строке номер "+i);
                this.arr[i][j] = scanner.nextInt();
            }
        }
    }

    void showMatrix(){
        for(int i=0; i<quantity;i++){
            for (int j=0; j<quantity;j++){
                if(j!=quantity-1) {
                    System.out.print(arr[i][j] + "  ");
                } else {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }

    int showLength(){
        return arr.length;
    }


    public Matrix sum(Matrix matrix){
        Matrix sumMatrix = new Matrix(this.quantity);
        if (this.quantity==matrix.quantity){
            for(int i=0; i<quantity;i++) {
                for (int j = 0; j < quantity; j++) {
                    sumMatrix.arr[i][j] = this.arr[i][j] + matrix.arr[i][j];
                }
            }
            return sumMatrix;
        } else {
            return null;
        }

    }

    public Matrix multiplication(float var){
        for(int i=0; i<quantity;i++) {
            for (int j = 0; j < quantity; j++) {
                this.arr[i][j] = this.arr[i][j] * var;
            }
        }
        return this;
    }
}
