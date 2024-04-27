package coursemanagementsystem;

public class Tests {
    public static void main(String[] args){
        Student s1 = new Student("Ahmed Said", 2101546, "hello", "Junior", "CSE");
        Department CSE = new Department("CSE");
        Teacher t1 = new Teacher("Nesma Rezk", 123, "teacher", CSE, 1000);
        System.out.println(t1.toString());
    }
}
