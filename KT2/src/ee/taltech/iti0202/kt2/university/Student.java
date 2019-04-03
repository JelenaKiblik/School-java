package ee.taltech.iti0202.kt2.university;

public class Student {

    private String name;
    private int Eap = 0;

    public Student(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getEap() {
        return Eap;
    }

    public String toString() {
        return name + "(" + Eap + ")";
    }
}
