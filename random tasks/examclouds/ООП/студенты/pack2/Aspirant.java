package pack2;

public class Aspirant extends Student {
    private String scienceWork;

    @Override
    public int getScholarship(){
        if(this.averageMark == 5){
            return 200;
        }else {
            return 180;
        }
    }
}
