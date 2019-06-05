package ee.taltech.iti0202.kt2.university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class University {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (students.contains(student)) return false;
        students.add(student);
        student.addUniversity(this);
        return true;
    }


    public Optional<Course> createCourse(String name, int eap) {
        if (eap < 1) return Optional.empty();
        if (name.isEmpty()) return Optional.empty();
        if (courses.stream().map(Course::getName).filter(s -> s.equals(name)).count() > 0) return Optional.empty();
        Course course = new Course(this, name, eap);
        courses.add(course);
        return Optional.of(course);
    }

    public List<Student> getStudents()  {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getFinishedCourses() {
        return courses.stream().filter(Course::isFinished).collect(Collectors.toList());
    }

    public List<Student> getStudentsOrderedByResults() {
        List<Student> orderedStudents = students.stream()
                .sorted(Comparator.comparingInt(Student::getPotentialEap))
                .collect(Collectors.toList());
        Collections.reverse(orderedStudents);
        return orderedStudents;
    }
}
