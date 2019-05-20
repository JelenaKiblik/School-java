package ee.taltech.iti0202.kt5.university;

import java.util.ArrayList;
import java.util.List;

public class Course extends University {

    private final int eap;
    private final String nameCourse;
    boolean isFinished = false;
    List<Student> studentInCourse = new ArrayList<>();
    private Course course;


    public Course(String name, int eap, String nameCourse) {
        super(name);
        this.eap = eap;
        this.nameCourse = nameCourse;
    }

    public boolean addStudent(Student student) {
        if (!studentInCourse.contains(student)) {
            studentInCourse.add(student);
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return studentInCourse;
    }

    public boolean finish() {
        if (!isFinished) {
            isFinished = true;
            for (Student student : studentInCourse) {
                student.eap = student.eap + course.eap;
            }
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        return isFinished;
    }

}
