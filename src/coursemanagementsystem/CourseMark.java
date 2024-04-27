package coursemanagementsystem;

public class CourseMark {

    private Course course;
    private int finalGrade = 0;
    private int midtermGrade = 0;
    private int activitiesGrade = 0;
    private boolean isFinished = false;

    CourseMark(Course course){
        this.course = course;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
        isFinished = true;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setMidtermGrade(int midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    public int getMidtermGrade() {
        return midtermGrade;
    }

    public void setActivitiesGrade(int activitiesGrade) {
        this.activitiesGrade = activitiesGrade;
    }

    public int getActivitiesGrade() {
        return activitiesGrade;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Course getCourse() {
        return course;
    }

}
