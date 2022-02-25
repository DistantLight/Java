package Animals;

public abstract class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

    @Override
    public void run(int length) {
        if(length>200){
            System.out.println("нельзя");
        } else {
            System.out.println(this.name + " пробежал " + length);
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("не умеет");
    }
}
