public class Phone {

    private String number;
    private String model;
    private int weight;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    void receiveCall(String name){
        System.out.println("Звонит "+name);
    }

    void receiveCall(String number, String name){
        System.out.println("Звонит "+name);
        System.out.println("С номером" + number);
    }

    Phone(String number,String model, int weight){
        this(number, model);
        this.weight = weight;
    }

    Phone(String number,String model){
        this.number = number;
        this.model = model;
    }

    Phone(){}

    void sendMassage(int ...arrNumbers){
        for(int x : arrNumbers){
            System.out.println(x);
        }
    }

}
