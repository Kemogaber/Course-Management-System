package project;

import java.util.List;

import project.courses.Course;

public class Tests {
    public static void main(String[] args) throws Exception {

        List<Course> saidAvailableCourses = Storage.said.getAvailableCourses();
        String[] avavialbleCOursesString = Storage.said.getAvailableCourseStrings();

        for (String s : avavialbleCOursesString) {
            System.out.println(s);
        }
    }
}
