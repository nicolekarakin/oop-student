package db;

import model.ComputerScienceStudent;
import model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentDBTest {

    @Test
    void getAllStudents() {
        Student[] studentDb = {
                new ComputerScienceStudent("Karl", "123"),
                new ComputerScienceStudent("Tina", "345"),
                new ComputerScienceStudent("Bob", "789"),
                new ComputerScienceStudent("Betty", "167"),
        };
        StudentDB db=new StudentDB(studentDb);
        Assertions.assertArrayEquals(studentDb,db.getAllStudents());
    }

}