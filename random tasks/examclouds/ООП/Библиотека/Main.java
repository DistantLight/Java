/*
"Читатели библиотеки". Определить класс Reader, хранящий такую информацию о пользователе библиотеки: ФИО, номер читательского билета, факультет, дата рождения, телефон. Методы takeBook(), returnBook().
Разработать программу, в которой создается массив объектов данного класса. Перегрузить методы takeBook(), returnBook():
- takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
- takeBook, который будет принимать переменное количество названий книг. Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
- takeBook, который будет принимать переменное количество объектов класса Book (создать новый класс, содержащий имя и автора книги). Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
 Аналогичным образом перегрузить метод returnBook(). Выводит на консоль сообщение "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия". Или  "Петров В. В. вернул 3 книги".

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        ArrayList<Reader> readers = new ArrayList<Reader>();
        System.out.println("Введите да, если хотите продолжить");
        while (scanner.nextLine().equals("да")) {
            readers.add(new Reader());
            readers.get(count).setData();
            readers.get(count).showInfo();
            System.out.println("Введите число, если хотите продолжить");
        }

        readers.get(0).takeBook(3);
        readers.get(0).takeBook("прикл","энци","повесть");

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setBookName("замок");
        book1.setAuthorName("Кафка");

        book2.setBookName("падение");
        book2.setAuthorName("камю");

        readers.get(0).takeBook(book1,book2);

    }
}
