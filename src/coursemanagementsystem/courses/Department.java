package coursemanagementsystem.courses;

import java.util.List;

public class Department {
    private String departementName;
    private List<Course> courses;

    public Department(String departementName){
        this.departementName = departementName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getDepartementName() {
        return departementName;
    }
    
    void addCourse(Course course){
        
    }

}
