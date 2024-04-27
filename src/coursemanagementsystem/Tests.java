package coursemanagementsystem;

import coursemanagementsystem.courses.Department;

public class Tests {
    public static void main(String[] args){
        System.out.println(Storage.said.toString());
        try {
            Storage.said.addCourse(Storage.said.department.getCourses().get(0));
            Storage.said.addCourse(Storage.said.department.getCourses().get(1));
            Storage.embeddedCourse.displayStudents();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
    }
}
