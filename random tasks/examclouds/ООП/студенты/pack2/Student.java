package pack2;

public class Student {
    String firstName;
    String lastName;
    String group;

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    double averageMark;

    public int getScholarship(){
        if(this.averageMark == 5){
            return 100;
        }else {
            return 80;
        }
    }
}
