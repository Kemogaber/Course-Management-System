/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

/**
 *
 * @author Fares Sultan
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class PersonalInformation {

    protected String name;
    protected int id;
    protected String password;

    protected String dateOfBirth;
    protected int numberOfEnrolledCourses;
    protected String department;
    

    public PersonalInformation() {
    }

    // Constructor to set the non-changeable information of the person
    public PersonalInformation(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public int calculateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(this.dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }



}
