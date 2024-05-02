package project;

import java.util.List;

import project.courses.Course;

public class Tests {
    public static void main(String[] args) throws Exception {


        Storage.updateSimulation();

        String name =  Storage.said.getCourseMark(Storage.embeddedCourse).getStudentName();

        /* for (String s : avavialbleCOursesString) {
            System.out.println(s);
        }

        System.out.println("=======================");

        for (Course course : saidAvailableCourses) {
            System.out.println(course.getCourseName());
        } */

        System.out.println(Storage.embeddedCourse.getCourseMarks().get(0).getStudent().getName());
    }
}
