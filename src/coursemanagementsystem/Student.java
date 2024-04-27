/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

import java.util.List;

/**
 *
 * @author Fares Sultan
 */
public class Student extends PersonalInformation{
    
    // Student's academic year Eg: Freshman, Sophomore, Junior.
    private String year;

    // Student's gpa: 0.0 - 4.0
    private float gpa;

    // Student's list of course marks.
    // Includes previously finished courses as well as currently enrolled courses.
    private List<CourseMark> courseMarks;
     

    public Student(String name, int id, String passWord, String year, String departement) {
        super(name, id, passWord, new Department("CSE"));
        this.year = year;
    }

    public String getYear() {
        return year;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\n" + "Year: " + year + "\n--------------------";
    }
    
    @Override
    public void addCourse(Course course) throws Exception {
        
    }

    @Override
    public void dropCourse(Course course) throws Exception {
        
    }

}
