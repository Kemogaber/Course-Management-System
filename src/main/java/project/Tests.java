package project;

import java.util.List;

import project.courses.Course;

public class Tests {
    public static void main(String[] args) throws Exception {


        Storage.said.addCourse(Storage.programming1Course);
        Storage.said.addCourse(Storage.embeddedCourse);

        Storage.said.getCourseMark(Storage.programming1Course).finish();
        Storage.said.getCourseMark(Storage.embeddedCourse).finish();

        List<Course> saidAvailableCourses = Storage.said.getAvailableCourses();
        String[] avavialbleCOursesString = Storage.said.getAvailableCourseStrings();
        String[] saidFinishedCourses = Storage.said.getFinishedCourseStrings();

        for (String s : avavialbleCOursesString) {
            System.out.println(s);
        }

        System.out.println("=======================");

        for (Course course : saidAvailableCourses) {
            System.out.println(course.getCourseName());
        }

        System.out.println("=======================");

        for (String string : saidFinishedCourses) {
            System.out.println(string);
        }

    }
}
