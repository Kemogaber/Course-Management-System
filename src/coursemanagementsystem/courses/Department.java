package coursemanagementsystem.courses;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departementName;
    private List<Course> courses = new ArrayList<Course>();

    public Department(String departementName){
        this.departementName = departementName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getDepartementName() {
        return departementName;
    }

    public void addCourse(Course course){
        courses.add(course);
    }
    
    @Override
    public String toString() {
        return departementName;
    }

}
