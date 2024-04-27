package coursemanagementsystem;

import coursemanagementsystem.courses.Course;
import coursemanagementsystem.courses.Department;
import coursemanagementsystem.courses.Student;

public class Tests {
    public static void main(String[] args) throws Exception {

        // Display available courses for student.
        Storage.said.displayAvailableCourses();

        // Students registers a course.
        Storage.said.addCourse(Storage.programming1Course);
        Storage.said.addCourse(Storage.controlCourse);

        // Tries to register a course in a different department.
        try {
            Storage.said.addCourse(Storage.electronicsCourse);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Display available courses again.
        Storage.said.displayAvailableCourses();

        // Select a course.
        Course selectedCourse = Storage.programming1Course;

        // Select a student.
        Student selectedStudent = Storage.said;

        // Modify student's marks for course.
        selectedStudent.getCourseMark(selectedCourse).setActivitiesGrade(19);
        selectedStudent.getCourseMark(selectedCourse).setMidtermGrade(17);
        selectedStudent.getCourseMark(selectedCourse).setFinalGrade(52);

        // Finish course.
        selectedStudent.getCourseMark(selectedCourse).finish();

        // Print mark.
        System.out.println(selectedStudent.getCourseMark(selectedCourse).getGradePoints());

        // Print student gpa.
        System.out.println(selectedStudent.getGPA());

        // Select a teacher.
        Teacher selectedTeacher = Storage.teacherCSE;

        // Select a course.
        selectedCourse = Storage.controlCourse;

        // Add courses for the teacher.
        selectedTeacher.addCourse(selectedCourse);
        selectedTeacher.addCourse(Storage.embeddedCourse);

        // Print teacher's courses.
        selectedTeacher.displayCourses();
        
    }
}
