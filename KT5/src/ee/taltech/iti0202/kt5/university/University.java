package ee.taltech.iti0202.kt5.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class University {
    String name;
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    private Course course;

    public University(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Course> createCourse(String name, int eap) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
        return Optional.empty();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getFinishedCourses() {
        List<Course> finishedCourse = new ArrayList<>();
        for (Course course : courses) {
            if (course.isFinished()) {
                finishedCourse.add(course);
            }
        }
        return finishedCourse;
    }

    public List<Student> getStudentsOrderedByResults() {
        List<Student> students = new ArrayList<>();

        return students;
    }
}
