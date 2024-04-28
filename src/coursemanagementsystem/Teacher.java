/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

import java.util.ArrayList;
import java.util.List;

import coursemanagementsystem.courses.Course;
import coursemanagementsystem.courses.Department;

/**
 *
 * @author Fares Sultan
 */
public class Teacher extends PersonalInformation {
    
    private float salary;
    private int weeklyHours;
    private List<Course> courses = new ArrayList<Course>();

    public Teacher(String name, int id, String password, Department department, float salary, int weeklyHours) {
        super(name, id, password, department);
        this.salary = salary;
        this.weeklyHours = weeklyHours;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public int getTotalStudents(){
        int studentsNum = 0;
        for (Course course : courses) {
            studentsNum += course.getStudents().size();
        }
        return studentsNum;
    }

    @Override
    public void displayCourses(){
        System.out.println(name + "'s courses: ");
        for (Course course: courses) {
            System.out.println(course.toString());
        }
    }

    @Override
    public void addCourse(Course course) throws Exception  {
        if (courses.contains(course)) {
            throw new Exception("Teacher already has this course.");
        }
        if (course.getDepartment() != this.getDepartment()) {
            throw new Exception("Teacher cannot add a course from a different department.");
        }
        courses.add(course);
    }

    @Override
    public void dropCourse(Course course) throws Exception {
        if (courses.contains(course)) {
            courses.remove(course);
        }
        else {
            throw new Exception("Teacher doesn't have this course.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Salary: " + salary + "Courses: \n" + courses.toString() + "\n--------------------" ;
    }

}
