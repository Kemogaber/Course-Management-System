package project.models.courses;

import project.models.Student;

/*
* Abstract Course Mark class that only defines the Course and Student
* It implements GPAMarkable and SemesterMarkable
* */
abstract public class CourseMark implements SemesterMarkable, GPAMarkable, Comparable<CourseMark> {
    protected final Course course;
    protected final Student student;

    CourseMark(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    @Override
    public GPA getGPA() {
        int totalMark = getFinalGrade() + getMidtermGrade() + getActivitiesGrade();

        if (totalMark >= 97) {
            return GPA.A_Plus;
        } else if (totalMark >= 93) {
            return GPA.A;
        }else if (totalMark >= 89) {
            return GPA.A_Minus;
        } else if (totalMark >= 84) {
            return GPA.B_Plus;
        } else if (totalMark >= 80) {
            return GPA.B;
        } else if (totalMark >= 76) {
            return GPA.B_Minus;
        } else if (totalMark >= 73) {
            return GPA.C_Plus;
        } else if (totalMark >= 70) {
            return GPA.C;
        } else if (totalMark >= 67) {
            return GPA.C_Minus;
        } else if (totalMark >= 64) {
            return GPA.D_Plus;
        } else if (totalMark >= 60) {
            return GPA.D;
        }
        return GPA.F;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public int compareTo(CourseMark o) { /* Comparing method to be used to sort students enrolled in the course alphabetically*/
        return this.getStudent().compareTo(o.getStudent());

    }
}
