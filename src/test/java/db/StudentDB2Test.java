package db;

import model.Address;
import model.BiologyStudent;
import model.ComputerScienceStudent;
import model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class StudentDB2Test {

    @Test
    void getAllStudents() {
        String[] keys= {"Karl","Bob","Betty","Tina"};
        StudentDB2 db=createDb2();
        System.out.println(db.getStudents());
        Assertions.assertArrayEquals(keys, db.getStudents().keySet().toArray());
    }

    @Test
    void getRandomStudent() {
        Student stDouble=new BiologyStudent("Tina","346",new
                Address("StreetX 89", "Verona", "zui52"),122);
        String[] keys= {"Karl","Bob","Betty","Tina"};
        StudentDB2 db=createDb2();
        db.addStudent(stDouble);
        for(int i=0;i<10;i++){
            Student st1=db.randomStudent();
            System.out.println(st1);
            Assertions.assertNotNull(st1);
        }
    }

    @Test
    void addStudent() {

        Student stDouble=new BiologyStudent("Tina","346",new
                Address("StreetX 89", "Verona", "zui52"),122);

        String[] keys= {"Karl","Bob","Betty","Tina"};
        StudentDB2 db=createDb2();
        db.addStudent(stDouble);

        System.out.println(db.getStudents());
        Assertions.assertArrayEquals(keys, db.getStudents().keySet().toArray());
        Assertions.assertEquals(2,db.getStudents().get("Tina").size());
    }

    @Test
    void deleteStudent() {
        List<String> keys=new ArrayList<>(Arrays.asList("Karl","Bob","Betty","Tina"));
        Student stDelete1=new ComputerScienceStudent("Betty", "167");
        Student stDelete2=new ComputerScienceStudent("Tina", "345");
        StudentDB2 db=createDb2();

        Assertions.assertTrue(keys.contains(stDelete1.getName()));
        db.deleteStudent(stDelete1.getId());
        Assertions.assertFalse(db.getStudents().keySet().contains(stDelete1.getName()));
        Assertions.assertEquals(null,db.getStudents().get("Betty"));

        Assertions.assertTrue(keys.contains(stDelete2.getName()));
        db.deleteStudent(stDelete2.getId());
        Assertions.assertFalse(db.getStudents().keySet().contains(stDelete2.getName()));
        Assertions.assertEquals(null,db.getStudents().get("Tina"));

        System.out.println(db.getStudents());
        Assertions.assertArrayEquals(new String[]{"Karl","Bob"}, db.getStudents().keySet().toArray());

    }

    private StudentDB2 createDb2(){
        List<String> keys=new ArrayList<>(Arrays.asList("Karl","Bob","Betty","Tina"));
        Map<String,List<Student>> stMp=new HashMap<>();
        List<Student> studentDb = Arrays.asList(
                new ComputerScienceStudent("Karl", "123"),
                new ComputerScienceStudent("Tina", "345"),
                new ComputerScienceStudent("Bob", "789"),
                new ComputerScienceStudent("Betty", "167")
        );

        for(Student st:studentDb){
            ArrayList<Student> arraylist = new ArrayList<>(Arrays.asList(st));
            stMp.put(st.getName(),arraylist);
        }
        return new StudentDB2(stMp);
    }
}