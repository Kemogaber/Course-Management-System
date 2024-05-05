package project.courses;

public interface GPAMarkable {
    GPA getGPA();

    enum GPA {
        A_Plus(4.0F, "A+"),
        A(4.0F, "A"),
        A_Minus(3.7F, "A-"),
        B_Plus(3.3F, "B+"),
        B(3.0F, "B"),
        B_Minus(2.7F, "B-"),
        C_Plus(2.3F, "C+"),
        C(2.0F, "C"),
        C_Minus(1.7F, "C-"),
        D_Plus(1.3F, "D+"),
        D(1.0F, "D"),
        F(0.0F, "F");

        private final float value;
        private final String text;

        GPA(float gpa, String text) {
            this.value = gpa;
            this.text = text;
        }

        public float getValue() {
            return value;
        }

        public String getText() {
            return text;
        }
    }
}
