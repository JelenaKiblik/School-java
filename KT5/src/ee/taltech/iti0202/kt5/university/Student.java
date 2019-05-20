package ee.taltech.iti0202.kt5.university;

public class Student {
    String name;
    int eap;

    public Student(String name) {
        this.name = name;
        this.eap = 0;
    }

    public String getName() {
        return name;
    }

    public int getEap() {
        return eap;
    }

    public String toString() {
        return "" + name + " (" + eap + ")";
    }

}
