package project;

import java.util.ArrayList;
import java.util.List;

import project.courses.Course;
import project.courses.Department;

public class Teacher extends FacultyMember {
    
    private float salary;
    private int weeklyHours;
    private final List<Course> courses = new ArrayList<>();

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

    public List<Course> getCourses() {
        return courses;
    }

    public int getTotalStudents(){
        int studentsNum = 0;
        for (Course course : courses) {
            studentsNum += course.getStudents().size();
        }
        return studentsNum;
    }

    public String[] getCourseStrings(){

        String[] coursesStrings = new String[courses.size()];

        for (int i = 0; i < coursesStrings.length; i++) {
            coursesStrings[i] = courses.get(i).getCourseName();
        }
        
        return coursesStrings;
    }

    @Override
    public void displayCourses(){
        System.out.println(name + "'s project.courses: ");
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
