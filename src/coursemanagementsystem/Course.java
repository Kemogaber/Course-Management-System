package coursemanagementsystem;

import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Course {
 private String coursename;
 private int CH; 
 private String code;
 private double gpa;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCH() {
        return CH;
    }

    public void setCH(int CH) {
        this.CH = CH;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
 Course(){
 this("",0,"",0.00);
 }
 Course(String coursename,int CH,String code,double gpa){
 this.coursename=coursename;
 this.CH=CH;
 this.code=code;
 this.gpa=gpa;
 }
 @Override 
 public boolean equals(Object o){
     Course k=(Course) o;
    if (this.getCH()==k.getCH() && this.getCode()== k.getCode() && this.getCoursename()==k.getCoursename()) 
 return true;
    return false;
 }
 
}
