package Animals;

public class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void run(int length) {
        if(length>500){
            System.out.println("нельзя");
        } else {
            System.out.println(this.name + " пробежал " + length);
        }
    }

    @Override
    public void swim(int length) {
        if(length>10){
            System.out.println("нельзя");
        } else {
            System.out.println(this.name + " проплыл " + length);
        }
    }
}
