package project;

import java.util.List;

import project.courses.Course;

public class Tests {
    public static void main(String[] args) throws Exception {


        Storage.updateSimulation();

        List<Course> saidAvailableCourses = Storage.said.getAvailableCourses();
        String[] avavialbleCOursesString = Storage.said.getAvailableCourseStrings();
        String[] saidFinishedCourses = Storage.said.getFinishedCourseStrings();
        String[] techerStrings = Storage.teacherCSE.getCourseStrings();

        /* for (String s : avavialbleCOursesString) {
            System.out.println(s);
        }

        System.out.println("=======================");

        for (Course course : saidAvailableCourses) {
            System.out.println(course.getCourseName());
        } */

        for (String string : techerStrings) {
            System.out.println(string);
        }

    }
}
