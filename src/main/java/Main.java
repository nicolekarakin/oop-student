import model.Student;

public class Main {


    public static void main(String[] args) {
        Student study1 = new Student("Helga", "f1");
        Student study2 = new Student("Hägar", "m1");
        Student study3 = new Student("Moritz", "m2");
        Student study4 = new Student("Mia", "u1");

        Student[] studentsArray = {study1, study2, study3, study4};
        StudentDB studentDb = new StudentDB (studentsArray);

        System.out.println(studentDb.deleteStudent("f1"));
        System.out.println(studentDb.randomStudent());
    }

}
