package coursemanagementsystem;

import coursemanagementsystem.courses.Course;
import coursemanagementsystem.courses.Department;
import coursemanagementsystem.courses.Student;

public class Storage {
    public static Department CSE = new Department("CSE");
    public static Course embeddedCourse = new Course("Intro to Embedded Systems", CSE, "CSE211", 3);
    public static Course programmingCourse = new Course("Advanced Programming", CSE, "CSE231", 3);
    
    public static Student said = new Student("Ahmed Said", 2101546, "said", "Junior", CSE);
}
