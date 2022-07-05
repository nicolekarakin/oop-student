import db.StudentDB;
import model.Address;
import model.ComputerScienceStudent;
import model.Student;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        Address adr1=new Address("street Q12","Rom","R54TZ");
        Address adr2=new Address("street HT","MILAN","87HHJ");

        Student study1 = new ComputerScienceStudent("Helga", "f1","php");
        Student study2 = new ComputerScienceStudent("Hägar", "m1","java");
        Student study3 = new ComputerScienceStudent("Moritz", "m2",adr1, 1,"C++");
        Student study4 = new ComputerScienceStudent("Mia", "u1",adr2,2,"python" );

        Student[] studentsArray = {study1, study2, study3, study4};
        StudentDB studentDb = new StudentDB (studentsArray);

        System.out.println(studentDb.deleteStudent("f1"));
        System.out.println(studentDb.randomStudent());
        System.out.println(studentDb);

        System.out.println("subject = " + Arrays.deepToString(args));

    }

}
