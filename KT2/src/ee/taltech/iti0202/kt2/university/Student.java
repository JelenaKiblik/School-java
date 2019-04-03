package ee.taltech.iti0202.kt2.university;

public class Student {

    private String name;
    public int eap = 0;

    public Student(String name) {
        this.name = name;
        this.eap = eap;
    }

    public String getName() {
        return name;
    }
    public int getEap() {
        return eap;
    }

    public String toString() {
        return name + "(" + eap + ")";
    }
}
