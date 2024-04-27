package coursemanagementsystem.courses;

import java.util.ArrayList;
import java.util.List;

import coursemanagementsystem.Teacher;

public class Course {
    private String courseName;
    private Department department;
    private String code;
    private int CH;
    private List<Student> students = new ArrayList<Student>();
    // TODO: determine if this is needed.
    private Teacher teacher;
    
    public Course(String courseName, Department department, String code, int CH){
        this.courseName = courseName;
        this.department = department;
        this.code = code;
        this.CH = CH;
        department.addCourse(this);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCH() {
        return CH;
    }

    public String getCode() {
        return code;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Add a student to Course.students
    // Visible only in coursemanagementsystem.courses
    void addStudent(Student student){
        students.add(student);
    }

    void removeStudent(Student student){
        students.remove(student);
    }

    // Prints the names of all registered students.
    public void displayStudents(){
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
    
    @Override
    public boolean equals(Object o) {
        Course k = (Course) o;
        if (this.getCH() == k.getCH() && this.getCode() == k.getCode() && this.getCourseName() == k.getCourseName())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + "\n" + code + "\n----------------";
    }

}