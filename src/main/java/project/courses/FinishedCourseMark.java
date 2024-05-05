package project.courses;

/*
* Encapsulates information about Course Mark for a Course already taken.
* It is immutable
* */
public class FinishedCourseMark extends CourseMark {

    final private int finalGrade;
    final private int midtermGrade;
    final private int activitiesGrade;

    public FinishedCourseMark(Course course, Student student, int finalGrade, int midtermGrade, int activitiesGrade){
        super(course, student);
        this.finalGrade = finalGrade;
        this.midtermGrade = midtermGrade;
        this.activitiesGrade = activitiesGrade;
    }

    @Override
    public int getFinalGrade() {
        return finalGrade;
    }

    @Override
    public int getMidtermGrade() {
        return midtermGrade;
    }

    @Override
    public int getActivitiesGrade() {
        return activitiesGrade;
    }
}
