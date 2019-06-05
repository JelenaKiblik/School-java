package ee.taltech.iti0202.kt2.university;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private University university;
    private String name;
    private int eap;
    private boolean finished = false;
    private List<Student> students = new ArrayList<>();

    public Course(University university, String name, int eap) {
        this.university = university;
        this.name = name;
        this.eap = eap;
    }

    public int getEap() {
        return eap;
    }

    public String getName() {
        return name;
    }

    public boolean addStudent(Student student) {
        if (students.contains(student)) return false;
        if (!student.isStudentOf(university)) return false;
        students.add(student);
        student.addCourse(this);
        return true;
    }

    public boolean finish() {
        if (finished) return false;
        finished = true;
        students.forEach(s -> s.addEap(eap));
        return true;
    }

    public boolean isFinished() {
        return finished;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String toString() {
        return String.format("%s: %s (%d)", university.getName(), name, eap);
    }
}
