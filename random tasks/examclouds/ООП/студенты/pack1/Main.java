package pack1;

import pack2.Aspirant;
import pack2.Student;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        Student student = new Aspirant();
        Student student1 = new Student();
        Aspirant aspirant = new Aspirant();
        Student[] students = new Student[5];

        students[0] = student;
        students[1] = student1;
        students[2] = aspirant;
        students[3] = new Student();
        students[4] = new Aspirant();

        students[4].setAverageMark(3);
        System.out.println(students[4].getScholarship());


        System.out.println("введите средние баллы 5и студентов(и аспирантов)");
        for (Student s : students){
            s.setAverageMark(scanner.nextDouble());
        }

        for (Student s : students){
            System.out.println(s.getScholarship());
        }

    }
}
