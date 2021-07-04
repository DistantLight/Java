/*

Даны два целых числа A и В. Выведите все числа от A до B включительно,
в порядке возрастания, если A < B, или в порядке убывания в противном случае. Использовать рекурсию.

 */

import java.util.Scanner;

public class Main {

    public static void func(int a, int b){

        if(a==b){
            System.out.println(b);
            return;
        }

        System.out.println(a);

        if(a<b){
            a+=1;
        } else {
            a-=1;
        }
        func(a,b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        func(a,b);

    }
}
