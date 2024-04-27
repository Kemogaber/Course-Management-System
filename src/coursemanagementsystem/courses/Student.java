/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem.courses;

import java.util.ArrayList;
import java.util.List;

import coursemanagementsystem.CourseMark;
import coursemanagementsystem.PersonalInformation;

/**
 *
 * @author Fares Sultan
 * Student class contians the student's info, and methods to add and drop courses.
 */
public class Student extends PersonalInformation{
    
    // Student's academic year Eg: Freshman, Sophomore, Junior.
    private String year;

    // Student's gpa: 0.0 - 4.0
    private float gpa;

    // Student's list of course marks.
    // Includes previously finished courses as well as currently enrolled courses.
    private List<CourseMark> courseMarks = new ArrayList<CourseMark>();
    
    private List<Course> availableCourses = new ArrayList<Course>(); 

    public Student(String name, int id, String passWord, String year, Department departement) {
        super(name, id, passWord, departement);
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public List<Course> getAvailableCourses() {
        return availableCourses;
    }

    public boolean hasCourse(Course course){
        for (CourseMark courseMark : courseMarks) {
            if (courseMark.getCourse() == course) {
                return true;
            }
        }
        return false;
    }

    public void updateAvaialableCourses(){

        availableCourses = new ArrayList<Course>();     // Reset the list.
        for (Course course : department.getCourses()) { // Loop over courses in student's department.
            if (!this.hasCourse(course)) {              // If the student doesn't have this course.
                availableCourses.add(course);           // Add it to availableCourses.
            }
        }
    }

    public void displayCourses(){
        System.out.println(name + "'s courses: ");
        for (CourseMark courseMark : courseMarks) {
            System.out.println(courseMark.getCourse().toString());
        }
    }

    public CourseMark getCourseMark(Course course) throws Exception{

        if (this.hasCourse(course)) {
            for (CourseMark courseMark : courseMarks) {
                if (courseMark.getCourse() == course) {
                    return courseMark;
                }
            }
        }

        throw new Exception("Student hasn't registered this course.");
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Year: " + year + "\n--------------------";
    }
    
    @Override
    public void addCourse(Course course) throws Exception {

        // Ensure that the course isn't duplicated.
        for (CourseMark courseMark : courseMarks) {
            if (courseMark.getCourse() == course) {
                throw new Exception("Student already has this course.");
            }
        }
        // Ensure that the course is from the same department,
        if (course.getDepartment() != this.getDepartment()) {
            throw new Exception("Student cannot add a course from a different department.");
        }
        else {
            courseMarks.add(new CourseMark(course));
            this.updateAvaialableCourses();
        }
    }

    @Override
    public void dropCourse(Course course) throws Exception {

        if(!this.hasCourse(course)){    // If course is not registered.
            throw new Exception("Student hasn't registered this course.");
        }
        
        // Else remove courseMark.
        for (CourseMark courseMark : courseMarks) {
            if (courseMark.getCourse() == course) {
                courseMarks.remove(courseMark);
                this.updateAvaialableCourses();
                break;
            }
        }

    }

}
