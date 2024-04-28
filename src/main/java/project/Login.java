package project;

import project.courses.Student;

public class Login {

    public static Student studentLogin(String userName, String password) throws Exception{

        for (Student student : Storage.students) {
            if (student.name.equals(userName) && student.password.equals(password)) {
                return student;
            }
        }

        throw new Exception("Wrong username or password.");
    }

    public static Teacher teacherLogin(String userName, String password) throws Exception{

        for (Teacher teacher : Storage.teachers) {
            if (teacher.name.equals(userName) && teacher.password.equals(password)) {
                return teacher;
            }
        }

        throw new Exception("Wrong username or password.");
    }
}
