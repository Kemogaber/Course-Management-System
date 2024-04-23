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
   protected String dateOfBirth;
   protected int id;
   protected int numberOfEnrolledCourses;
   protected String department;
   protected String password;
    
   
   public PersonalInformation() {
   }
   
   // Constructor to set the non-changeable information of the person 
    public PersonalInformation(String name, String department, int id) {
        this.name = name;
        this.department = department;
        this.id = id;
    }

    protected void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isEmpty() || !dateOfBirth.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Invalid dateOfBirth format. Please use DD/MM/YYYY");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setDepartment(String department) { // adding the option to transfer from one department to another
        this.department = department;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int calculateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(this.dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }

    @Override
    public String toString() {
        return """
               PersonalInformation:
               Name: """ + name + "\nId: " + id + "\nDepartment: " + department + "\nPassword: " + password + "\n Date of brith: " + dateOfBirth + "\n Age: " + calculateAge() + "\n--------------------";
    }

    
}
