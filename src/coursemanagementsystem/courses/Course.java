package coursemanagementsystem.courses;

public class Course {
    private String courseName;
    private Department department;
    private String code;
    private int CH;
    
    Course(String courseName, Department department, String code, int CH){
        this.courseName = courseName;
        this.department = department;
        this.code = code;
        this.CH = CH;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCH() {
        return CH;
    }

    public String getCode() {
        return code;
    }

    public Department getDepartment() {
        return department;
    }
    
    @Override
    public boolean equals(Object o) {
        Course k = (Course) o;
        if (this.getCH() == k.getCH() && this.getCode() == k.getCode() && this.getCourseName() == k.getCourseName())
            return true;
        return false;
    }

}
