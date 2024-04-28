/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem.java.courses;

import java.util.ArrayList;
import java.util.List;

import project.CourseMark;
import project.PersonalInformation;

/**
 *
 * @author Fares Sultan
 * Student class contians the student's info, and methods to add and drop project.courses.
 */
public class Student extends PersonalInformation{
    
    // Student's academic year Eg: Freshman, Sophomore, Junior.
    private String year;

    // Student's list of course marks.
    // Includes previously finished project.courses as well as currently enrolled project.courses.
    private List<CourseMark> courseMarks = new ArrayList<CourseMark>();
    
    private List<Course> availableCourses = new ArrayList<Course>();

    // TODO: total CHs

    public Student(String name, int id, String passWord, String year, Department departement) {
        super(name, id, passWord, departement);
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public List<Course> getAvailableCourses() {
        this.updateAvaialableCourses();
        return availableCourses;
    }

    public List<CourseMark> getCourseMarks() {
        return courseMarks;
    }

    public void displayAvailableCourses(){
        this.updateAvaialableCourses();
        System.out.println("Courses available for " + name + ":");
        for (Course course : availableCourses) {
            System.out.println(course.toString());
        }
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
        for (Course course : department.getCourses()) { // Loop over project.courses in student's department.
            if (!this.hasCourse(course)) {              // If the student doesn't have this course.
                availableCourses.add(course);           // Add it to availableCourses.
            }
        }
    }

    public String[] getFinishedCourseStrings(){

        int length = 0;
        int i=0;

        for (CourseMark courseMark : courseMarks) {
            length = (courseMark.isFinished())?length+1:length;
        }

        String[] finishedCourses = new String[length];
        for (CourseMark courseMark : courseMarks) {
            if (courseMark.isFinished()) {
                finishedCourses[i]= courseMark.getCourse().getCourseName();
                i++;
            }
        }
        
        return finishedCourses;
    }

    public String[] getAvailableCourseStrings(){

        int length = 0;
        int i=0;


        for (CourseMark courseMark : courseMarks) {
            length = (!courseMark.isFinished())?length+1:length;
        }

        String[] finishedCourses = new String[length];
        for (CourseMark courseMark : courseMarks) {
            if (!courseMark.isFinished()) {
                finishedCourses[i]= courseMark.getCourse().getCourseName();
                i++;
            }
        }
        
        return finishedCourses;
    }

    @Override
    public void displayCourses(){
        System.out.println(name + "'s project.courses: ");
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

    public double getGPA(){
        double points = 0;
        int creditHours = 0;
        for (CourseMark courseMark : courseMarks) {
            if (courseMark.isFinished()) {
                points += courseMark.getGradePoints() * courseMark.getCourse().getCH();
                creditHours += courseMark.getCourse().getCH();
            }
        }
        return points/creditHours;
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
            courseMarks.add(new CourseMark(course, this));
            this.updateAvaialableCourses();
            course.addStudent(this);
        }
    }

    @Override
    public void dropCourse(Course course) throws Exception {

        if(!this.hasCourse(course)){    // If course is not registered.
            throw new Exception("Student hasn't registered this course.");
        }
        if (this.getCourseMark(course).isFinished()) {
            throw new Exception("Course is already finished.");
        }
        
        // Else remove courseMark.
        for (CourseMark courseMark : courseMarks) {
            if (courseMark.getCourse() == course) {
                courseMarks.remove(courseMark);
                this.updateAvaialableCourses();
                course.removeStudent(this);
                break;
            }
        }

    }

}
