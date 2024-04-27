/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

import coursemanagementsystem.courses.Course;
import coursemanagementsystem.courses.Department;

/**
 *
 * @author Fares Sultan
 */

public abstract class PersonalInformation {

    protected String name;
    protected int id;
    protected String password;

    protected int numberOfEnrolledCourses;
    protected Department department;
    

    public PersonalInformation() {
    }

    // Constructor to set the non-changeable information of the person
    public PersonalInformation(String name, int id, String password, Department department) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public abstract void addCourse(Course course) throws Exception;

    public abstract void dropCourse(Course course) throws Exception;

    @Override
    public String toString() {
        return """
                PersonalInformation:
                Name: """ + name + "\nId: " + id + "\nPassword: " + password + "\nDepartment: " + department.getDepartementName();
    }

}
