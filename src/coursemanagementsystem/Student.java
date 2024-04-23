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
    
    private String level;
    private float gpa;
    // course marks 

    public Student(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public float getGpa() {
        return gpa;
    }
    

    public void setLevel(String level) {
        this.level = level;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    protected void CalculateGpa(){


    }

    
}
