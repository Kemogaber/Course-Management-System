package project.courses;

/*
* Encapsulates information about Course Mark for a Course in progress.
* It is mutable
* */
public class InProgressCourseMark extends CourseMark {
    private int finalGrade = 0;
    private int midtermGrade = 0;
    private int activitiesGrade = 0;

    public InProgressCourseMark(Course course, Student student){
        super(course, student);
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public int getFinalGrade() {
        return finalGrade;
    }

    public void setMidtermGrade(int midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    @Override
    public int getMidtermGrade() {
        return midtermGrade;
    }

    public void setActivitiesGrade(int activitiesGrade) {
        this.activitiesGrade = activitiesGrade;
    }

    @Override
    public int getActivitiesGrade() {
        return activitiesGrade;
    }
}
