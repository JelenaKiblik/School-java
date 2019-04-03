package ee.taltech.iti0202.kt2.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class University {

    private String name;
    public List<Student> studentsInUniver = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (!studentsInUniver.contains(student)) {
            studentsInUniver.add(student);
            return true;
        } else {
            return false;
        }
    }


    public Optional<Course> createCourse(String name, int eap) {
//        if ((eap > 0) && name )
        return null;
    }

    public List<Student> getStudents()  {
        return studentsInUniver;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getFinishedCourses(){
        return null;
    }

    public List<Student> getStudentsOrderedByResults() {
        return null;
    }
}
