package ee.taltech.iti0202.kt2.university;

import java.util.ArrayList;
import java.util.List;
import ee.taltech.iti0202.kt2.university.University;
import ee.taltech.iti0202.kt2.university.Student;

public class Course {

    private String name;
    public List<Student> studentsInCourse = new ArrayList<>();
    public List<Student> studentsInUniver;
    public Student student;

    public Course(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (studentsInUniver.contains(student)) {
            if (!studentsInCourse.contains(student)) {
                studentsInCourse.add(student);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public List<Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    public boolean finish() {
        return false;
    }

    public boolean isFinished() {
        return false;
    }

    public String toString() {
        return name + " :" + name + "(" + student.eap + ")";
    }
}
