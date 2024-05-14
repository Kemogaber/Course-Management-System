package project.data;

import project.models.Teacher;
import project.models.Student;

public class Login {

    public static Student studentLogin(String userName, String password) throws Exception{

        for (Student student : Storage.students) {
            if (student.getName().equals(userName) && student.getPassword().equals(password)) {
                return student;
            }
        }

        throw new Exception("Wrong username or password.");
    }

    public static Teacher teacherLogin(String userName, String password) throws Exception{

        for (Teacher teacher : Storage.teachers) {
            if (teacher.getName().equals(userName) && teacher.getPassword().equals(password)) {
                return teacher;
            }
        }

        throw new Exception("Wrong username or password.");
    }
}
