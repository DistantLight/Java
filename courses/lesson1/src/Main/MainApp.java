package Main;
import Animals.*;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Animal [] animals = new Animal[]{
                new Dog("боб"),
                new HomeCat("эу"),
                new Tiger("эуъ")
        };

        System.out.println(Animal.getCounter());

        for (Animal animal: animals){
            System.out.println("дистанция:");
            animal.run(scanner.nextInt());
            animal.swim(scanner.nextInt());
        }
    }
}

