package ee.taltech.iti0202.kt2.university;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int eap = 0;
    private University university;
    private List<University> universities =  new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEap() {
        return eap;
    }

    public void addEap(int eap) {
        this.eap += eap;
    }

    public boolean isStudentOf(University university) {
        return universities.contains(university);
    }

    public void addUniversity(University university) {
        this.universities.add(university);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public int getPotentialEap() {
        return 1000 * eap
                + courses.stream()
                .filter(c -> !c.isFinished())
                .mapToInt(Course::getEap)
                .sum();
    }

    public String toString() {
        return String.format("%s (%d)", name, eap);
    }
}
