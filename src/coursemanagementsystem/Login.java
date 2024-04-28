package coursemanagementsystem;

import coursemanagementsystem.courses.Student;

public class Login {
    public static Student studentLogin(String userName, String password) throws Exception{
        for (Student student : Storage.students) {
            if (student.name.equals(userName) && student.password.equals(password)) {
                return student;
            }
        }

        throw new Exception("Wrong username or password.");
    }
}
