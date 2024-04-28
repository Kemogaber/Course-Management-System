package project;

public class Tests {
    public static void main(String[] args) throws Exception {

        /* // Display available project.courses for student.
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

        // Display available project.courses again.
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
        Storage.said.getCourseMark(Storage.controlCourse).finish();

        // Print mark.
        System.out.println(selectedStudent.getCourseMark(selectedCourse).getGradePoints());

        // Print student gpa.
        System.out.println(selectedStudent.getGPA());

        // Select a teacher.
        Teacher selectedTeacher = Storage.teacherCSE;

        // Select a course.
        selectedCourse = Storage.controlCourse;

        // Add project.courses for the teacher.
        selectedTeacher.addCourse(selectedCourse);
        selectedTeacher.addCourse(Storage.embeddedCourse);

        // Print teacher's project.courses.
        selectedTeacher.displayCourses();

        // Test login.
        try {
            selectedStudent = Login.studentLogin("Ahmed Said", "said");

            System.out.println(selectedStudent.toString());
        } catch (Exception e) {
            // TODO: handle exception
        }
        */

        Storage.teacherCSE.addCourse(Storage.programming1Course);
        Storage.teacherCSE.addCourse(Storage.controlCourse);
         

        Storage.said.addCourse(Storage.programming1Course);
        Storage.said.addCourse(Storage.programming2Course);
        Storage.said.addCourse(Storage.controlCourse);
        Storage.said.addCourse(Storage.embeddedCourse);

        /* Storage.said.getCourseMark(Storage.programming1Course).finish();
        Storage.said.getCourseMark(Storage.controlCourse).finish() */;

        
        /* for (String string : Storage.said.getFinishedCourseStrings()) {
            System.out.println(string);
        }
        
        System.out.println("==============================");

        for (String string : Storage.said.getAvailableCourseStrings()) {
            System.out.println(string);
        } */

        System.out.println(Storage.teacherCSE.getTotalStudents());
    }
}
