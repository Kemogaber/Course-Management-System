/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.courses;

import java.util.ArrayList;
import java.util.List;

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

    private List<CourseMark> finishedCourseMarks = new ArrayList<CourseMark>();
    
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

    public List<CourseMark> getFinishedCourseMarks() {
        return finishedCourseMarks;
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

    public String[] getCourseMarkStrings(){
        String[] courseMarksStrings = new String[courseMarks.size()];

        for (int i = 0; i < courseMarksStrings.length; i++) {
            courseMarksStrings[i] = courseMarks.get(i).getCourse().getCourseName();
        }
        
        return courseMarksStrings;
    }

    public String[] getFinishedCourseStrings(){

        String[] finishedCoursesString = new String[finishedCourseMarks.size()];

        for (int i = 0; i < finishedCoursesString.length; i++) {
            finishedCoursesString[i] = finishedCourseMarks.get(i).getCourse().getCourseName();
        }
        
        return finishedCoursesString;
    }

    void finishCourseMark(CourseMark courseMark){
        finishedCourseMarks.add(courseMark);
    }

    public String[] getAvailableCourseStrings(){

        int length = 0;
        int i=0;
        

        for (Course course : department.getCourses()) {
            if (!this.hasCourse(course)) {
                length++;
            }
        }
        
        String[] availableCourses = new String[length];

        for (Course course : department.getCourses()) {
            if (!this.hasCourse(course)) {
                availableCourses[i] = course.getCourseName();
                i++;
            }
        }

        return availableCourses;
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

    public int getTotalCH(){
        int CH = 0;
        for (CourseMark courseMark : courseMarks) {
            CH += courseMark.getCourse().getCH();
        }
        return CH;
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
