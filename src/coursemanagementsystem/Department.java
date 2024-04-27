package coursemanagementsystem;

import java.util.List;

public class Department {
    private String departementName;
    private List<Course> courses;

    Department(String departementName){
        this.departementName = departementName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getDepartementName() {
        return departementName;
    }
    
}
