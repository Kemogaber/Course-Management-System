package project;

import project.courses.Course;
import project.courses.Student;

public class CourseMark {

    private Course course;
    private int finalGrade = 0;
    private int midtermGrade = 0;
    private int activitiesGrade = 0;
    private boolean isFinished = false;
    private Student student;

    public CourseMark(Course course, Student student){
        this.course = course;
        this.student = student;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setMidtermGrade(int midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    public int getMidtermGrade() {
        return midtermGrade;
    }

    public void setActivitiesGrade(int activitiesGrade) {
        this.activitiesGrade = activitiesGrade;
    }

    public int getActivitiesGrade() {
        return activitiesGrade;
    }

    public Student getStudent() {
        return student;
    }

    // Finish a course and make it uneditable.
    // To be used at the end of the semester.
    public void finish(){
        isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Course getCourse() {
        return course;
    }

    // TODO: Finish implementation in a cleaner way.
    public double getGradePoints(){
        int totalMark = finalGrade + midtermGrade + activitiesGrade;
        if (totalMark >= 93) {
            return 4.0;
        }else if (totalMark >= 89) {
            return  3.7;
        } else if (totalMark >= 84) {
            return 3.3;
        } else if (totalMark >= 80) {
            return 3.0;
        } else if (totalMark >= 76) {
            return 2.7;
        } else if (totalMark >= 73) {
            return 2.3;
        } else if (totalMark >= 70) {
            return 2.0;
        } else if (totalMark >= 67) {
            return 1.7;
        }
        return 0;
    }

    // TODO: Implement this.
    // Calculates and returns the grade letter (Eg: A, B-, C+) for this courseMark.
    public String getGradeLetter(){
        return "A+";
    }

}
