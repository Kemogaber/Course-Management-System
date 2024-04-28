package coursemanagementsystem;

import coursemanagementsystem.courses.Course;
import coursemanagementsystem.courses.Department;
import coursemanagementsystem.courses.Student;

public class Storage {

    // Define departments=====================================================================

    public static Department cseDepartment = new Department("CSE");
    public static Department eceDepartment = new Department("ECE");
    public static Department epmDepartment = new Department("EPM");
    public static Department phmDepartment = new Department("PHM");

    // Array of available departments.
    public static Department[] departements= new Department[]{cseDepartment, eceDepartment, epmDepartment, phmDepartment};


    // Define new Courses========================================================================

    public static Course embeddedCourse = new Course("Intro to Embedded Systems", cseDepartment, "CSE211", 3);
    public static Course programming2Course = new Course("Advanced Programming", cseDepartment, "CSE231", 3);
    public static Course digitalCourse = new Course("Digital Circuits", eceDepartment, "ECE210", 3);
    public static Course commsCourse = new Course("Fundamentals of Communication", eceDepartment, "ECE214", 3);
    public static Course energyCourse = new Course("Energy and Renewables", epmDepartment, "EPM213", 3);
    public static Course circuits2Course = new Course("Circuits 2", epmDepartment, "EPM221", 4);
    
    // Array of courses to register.
    public static Course[] newCourses = new Course[]{embeddedCourse, programming2Course, digitalCourse, commsCourse, energyCourse, circuits2Course};

    // Define some finished courses===================================================================

    public static Course programming1Course = new Course("Computer Programming", cseDepartment, "CSE112", 3);
    public static Course controlCourse = new Course("Control", cseDepartment, "CSE221", 4);
    public static Course signalsCourse = new Course("Signals and Systems", eceDepartment, "ECE224", 4);
    public static Course electronicsCourse = new Course("Electronics", eceDepartment, "ECE216", 3);
    public static Course measurementCourse = new Course("Electrical Measurements", epmDepartment, "EPM131", 3);
    public static Course materialsCourse = new Course("Electrical Materials", epmDepartment, "EPM223", 2);

    // Array of finished courses.
    public static Course[] finishedCourses = new Course[]{programming1Course, controlCourse, signalsCourse, electronicsCourse, measurementCourse, materialsCourse};

    // Define some students====================================================================================

    public static Student said = new Student("Ahmed Said", 2101546, "said", "Junior", cseDepartment);
    public static Student hesham = new Student("Hesham Nabil", 2101000, "hesham", "Junior", eceDepartment);
    public static Student mohamed = new Student("Mohamed Awad", 2100500, "said", "Junior", cseDepartment);

    // Define some teachers=======================================================================================

    public static Teacher teacherCSE = new Teacher("CSE Teacher", 1, "cse", cseDepartment, 1000);
    public static Teacher teacherECE = new Teacher("ECE Teacher", 2, "cse", eceDepartment, 1000);
    public static Teacher teacherEPM = new Teacher("EPM Teacher", 3, "cse", epmDepartment, 1000);

    // Array of registered users, students and teacher alike.
    public static PersonalInformation users[] = new PersonalInformation[]{said, hesham, mohamed, teacherCSE, teacherECE, teacherEPM};

    public static Student students[] = new Student[]{said, hesham, mohamed};
    public static Teacher teachers[] = new Teacher[]{teacherCSE, teacherECE, teacherEPM};
}
