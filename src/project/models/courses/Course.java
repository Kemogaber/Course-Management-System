package project.models.courses;
import java.util.ArrayList;
import java.util.*;
import project.models.Student;
import project.models.Teacher;

public class Course implements Comparable<Course>{
    private final String courseName;
    private final Department department;
    private final String code;
    private final int CH;
    private final List<Student> students = new ArrayList<>();

    // TODO: determine if this is needed.
    private Teacher teacher;
    
    public Course(String courseName, Department department, String code, int CH){
        this.courseName = courseName;
        this.department = department;
        this.code = code;
        this.CH = CH;
        department.addCourse(this);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCH() {
        return CH;
    }

    public String getCode() {
        return code;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Returns the course marks for all the students in this course.
    public List<CourseMark> getCourseMarks() {
        List<CourseMark> courseMarks = new ArrayList<>();

        for (Student student : students) {
            try {
                courseMarks.add(student.getCourseMark(this));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return courseMarks;
    }

    // Finishing a Course should be handled by the Course itself or Student
    // This function finishes course a student has taken by replacing InProgressCourseMark with a FinishedCourseMark
    public void finish(Student student) {
        Student candidate = students.stream().filter(p -> p == student).findFirst().orElseThrow(RuntimeException::new);

        try {
            InProgressCourseMark inProgressCourseMark = (InProgressCourseMark) candidate.getCourseMark(this);
            FinishedCourseMark finishedCourseMark = new FinishedCourseMark(inProgressCourseMark.course, inProgressCourseMark.student, inProgressCourseMark.getFinalGrade(), inProgressCourseMark.getMidtermGrade(), inProgressCourseMark.getActivitiesGrade());
            candidate.getCourseMarks().remove(inProgressCourseMark);
            candidate.getCourseMarks().add(finishedCourseMark);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Add a student to Course.students
    // Visible only in project.project.courses
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    // Prints the names of all registered students.
    public void displayStudents(){
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
    
    @Override
    public boolean equals(Object o) {
        Course k = (Course) o;
        if (this.getCH() == k.getCH() && this.getCode() == k.getCode() && this.getCourseName() == k.getCourseName())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + "\n" + code + "\n----------------";
    }

    @Override
    public int compareTo(Course t) {   // comapring courses by there names alphabically
    
       return this.getCourseName().compareTo(t.getCourseName()) ;
                
    }   
    
}


