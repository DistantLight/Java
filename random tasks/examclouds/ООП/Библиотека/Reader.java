import java.util.Scanner;

public class Reader {
    private String name;
    private int number;
    private String fack;
    private String birthday;
    private String phoneNumber;

    void setData(){
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        this.number = scanner.nextInt();
        scanner.nextLine();
        this.fack = scanner.nextLine();
        this.birthday = scanner.nextLine();
        this.phoneNumber = scanner.nextLine();
    }

    void showInfo(){
        System.out.println(name);
        System.out.println(number);
        System.out.println(fack);
        System.out.println(birthday);
        System.out.println(phoneNumber);
    }

    void takeBook(int count){
        System.out.println(name+" взял "+ count + " книги");

    }

    void takeBook(String ...arrBooks){
        System.out.print(name + " взял книги : " );
        for(String x:arrBooks){
            System.out.print(x+", ");
        }
        System.out.print(".");
    }

    void takeBook(Book ...arrBooks){
        System.out.println(name + " взял книги : " );
        for(Book x:arrBooks){
            System.out.println(x.getBookName() + " автора " + x.getAuthorName());
        }

    }


}
