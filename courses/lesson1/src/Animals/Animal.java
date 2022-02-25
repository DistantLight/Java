package Animals;

public abstract class Animal {
    String name;
    static int counter;

    public Animal(String name){
        this.name = name;
        counter++;
    }

    public static int getCounter(){
        return counter;
    }

    public abstract void run(int length);
    public abstract void swim(int length);
}
