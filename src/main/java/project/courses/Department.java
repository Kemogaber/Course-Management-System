package project.courses;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String departmentName;
    private final List<Course> courses = new ArrayList<>();

    public Department(String departmentName){
        this.departmentName = departmentName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addCourse(Course course){
        courses.add(course);
    }
    
    @Override
    public String toString() {
        return departmentName;
    }

}
