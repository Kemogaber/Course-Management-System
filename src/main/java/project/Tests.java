package project;

import java.util.List;

import project.courses.Course;

public class Tests {
    public static void main(String[] args) throws Exception {

        List<Course> saidAvailableCourses = Storage.said.getAvailableCourses();

        for (Course course : saidAvailableCourses) {
            System.out.println(course.getCourseName());
        }
    }
}
