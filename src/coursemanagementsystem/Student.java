/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

/**
 *
 * @author Fares Sultan
 */
public class Student extends PersonalInformation{
    
    private String year;
    private float gpa;
    // course marks 

    public Student(String name, int id, String passWord, String year) {
        super(name, id, passWord);
        this.year = year;
    }

    public String getYear() {
        return year;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
