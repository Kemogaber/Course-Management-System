package project.data;

import project.controllers.FacultyMember;
import project.models.Teacher;
import project.models.courses.Course;
import project.models.courses.Department;
import project.models.courses.InProgressCourseMark;
import project.models.Student;

public class Storage {

    // Define
    // departments=====================================================================

    public static Department cseDepartment = new Department("CSE");
    public static Department eceDepartment = new Department("ECE");
    public static Department epmDepartment = new Department("EPM");
    public static Department phmDepartment = new Department("PHM");

    // Array of available departments.
    public static Department[] departements = new Department[] { cseDepartment, eceDepartment, epmDepartment,
            phmDepartment };

    // Define new
    // Courses========================================================================

    public static Course embeddedCourse = new Course("Intro to Embedded Systems", cseDepartment, "CSE211", 3);
    public static Course programming2Course = new Course("Advanced Programming", cseDepartment, "CSE231", 3);
    public static Course digitalCourse = new Course("Digital Circuits", eceDepartment, "ECE210", 3);
    public static Course commsCourse = new Course("Fundamentals of Communication", eceDepartment, "ECE214", 3);
    public static Course energyCourse = new Course("Energy and Renewables", epmDepartment, "EPM213", 3);
    public static Course circuits2Course = new Course("Circuits 2", epmDepartment, "EPM221", 4);
    public static Course computerorganization = new Course("Computer Organization", cseDepartment, "CSE217", 3);

    // Array of project.courses to register.
    public static Course[] newCourses = new Course[] { embeddedCourse, programming2Course, digitalCourse, commsCourse,
            energyCourse, circuits2Course };

    // Define some finished
    // project.courses===================================================================

    public static Course programming1Course = new Course("Computer Programming", cseDepartment, "CSE112", 3);
    public static Course controlCourse = new Course("Control", cseDepartment, "CSE221", 4);
    public static Course signalsCourse = new Course("Signals and Systems", eceDepartment, "ECE224", 4);
    public static Course electronicsCourse = new Course("Electronics", eceDepartment, "ECE216", 3);
    public static Course measurementCourse = new Course("Electrical Measurements", epmDepartment, "EPM131", 3);
    public static Course materialsCourse = new Course("Electrical Materials", epmDepartment, "EPM223", 2);

    // Array of finished project.courses.
    public static Course[] finishedCourses = new Course[] { programming1Course, controlCourse, signalsCourse,
            electronicsCourse, measurementCourse, materialsCourse };

    // Define some
    // students====================================================================================

    public static Student said = new Student("Ahmed Said", 2101546, "said", "Junior", cseDepartment);
    public static Student kareem = new Student("Kareem Gaber", 2101545, "kareem", "Junior", cseDepartment);
    public static Student fares = new Student("Fares Sultan", 2101545, "fares", "Junior", cseDepartment);
    public static Student hesham = new Student("Hesham Nabil", 2101000, "hesham", "Junior", eceDepartment);
    public static Student mohamed = new Student("Mohamed Awad", 2100500, "mohamed", "Junior", cseDepartment);

    // Define some
    // teachers=======================================================================================

    public static Teacher teacher1 = new Teacher("Teacher Mohamed", 1, "mohamed", cseDepartment, 13000, 25);
    public static Teacher teacherECE = new Teacher("Teacherx", 2, "cse", eceDepartment, 1000, 40);
    public static Teacher teacher2 = new Teacher("Teacher Sara", 1, "sara", cseDepartment, 5400, 25);
    public static Teacher teacherEPM = new Teacher("EPM Teacher", 3, "cse", epmDepartment, 1000, 30);

    // Array of registered users, students and teacher alike.
    public static FacultyMember users[] = new FacultyMember[] { said, hesham, mohamed, teacher1, teacherECE,
            teacherEPM };

    public static Student students[] = new Student[] { said, hesham, mohamed, kareem, fares };
    public static Teacher teachers[] = new Teacher[] { teacher1, teacherECE, teacherEPM, teacher2 };

    public static void updateSimulation() {
        try {
            
            // =======================================================
            // Said

            said.addCourse(embeddedCourse);

            ((InProgressCourseMark) (said.getCourseMark(embeddedCourse))).setFinalGrade(35);
            ((InProgressCourseMark) (said.getCourseMark(embeddedCourse))).setMidtermGrade(15);
            ((InProgressCourseMark) (said.getCourseMark(embeddedCourse))).setActivitiesGrade(17);
            embeddedCourse.finish(said);
            said.addCourse(programming1Course);

            ((InProgressCourseMark) (said.getCourseMark(programming1Course))).setFinalGrade(40);
            ((InProgressCourseMark) (said.getCourseMark(programming1Course))).setMidtermGrade(15);
            ((InProgressCourseMark) (said.getCourseMark(programming1Course))).setActivitiesGrade(18);
            programming1Course.finish(said);
            said.addCourse(computerorganization);
            said.addCourse(controlCourse);
            said.addCourse(programming2Course);

            // =======================================================
            // Fares

            fares.addCourse(embeddedCourse);
            ((InProgressCourseMark) (fares.getCourseMark(embeddedCourse))).setFinalGrade(59);
            ((InProgressCourseMark) (fares.getCourseMark(embeddedCourse))).setMidtermGrade(18);
            ((InProgressCourseMark) (fares.getCourseMark(embeddedCourse))).setActivitiesGrade(15);
            embeddedCourse.finish(fares);
            fares.addCourse(programming1Course);

            /* programming1Course.finish(said); */
            ((InProgressCourseMark) (fares.getCourseMark(programming1Course))).setFinalGrade(49);
            ((InProgressCourseMark) (fares.getCourseMark(programming1Course))).setMidtermGrade(18);
            ((InProgressCourseMark) (fares.getCourseMark(programming1Course))).setActivitiesGrade(13);
            programming1Course.finish(fares);
            fares.addCourse(computerorganization);
            fares.addCourse(controlCourse);
            fares.addCourse(programming2Course);

            // =======================================================
            // Kareem

            kareem.addCourse(embeddedCourse);
            ((InProgressCourseMark) (kareem.getCourseMark(embeddedCourse))).setFinalGrade(48);
            ((InProgressCourseMark) (kareem.getCourseMark(embeddedCourse))).setMidtermGrade(20);
            ((InProgressCourseMark) (kareem.getCourseMark(embeddedCourse))).setActivitiesGrade(10);
            embeddedCourse.finish(kareem);
            kareem.addCourse(programming2Course);

            /* programming1Course.finish(said); */
            ((InProgressCourseMark) (kareem.getCourseMark(programming2Course))).setFinalGrade(60);
            ((InProgressCourseMark) (kareem.getCourseMark(programming2Course))).setMidtermGrade(20);
            ((InProgressCourseMark) (kareem.getCourseMark(programming2Course))).setActivitiesGrade(18);
            programming2Course.finish(kareem);
            kareem.addCourse(computerorganization);
            kareem.addCourse(controlCourse);
            kareem.addCourse(programming1Course);

            teacher1.addCourse(programming1Course);
            teacher1.addCourse(computerorganization);

            teacher2.addCourse(programming2Course);
            teacher2.addCourse(controlCourse);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
