package coursemanagementsystem;

import coursemanagementsystem.courses.Student;

public class Login {
    public static Student studentLogin(String password, String userName) throws Exception{
        for (Student student : Storage.students) {
            if (student.name == userName && student.password == password) {
                return student;
            }
        }

        throw new Exception("Wrong username or password.");
    }
}
