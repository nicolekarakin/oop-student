package db;

import model.Address;
import model.BiologyStudent;
import model.ComputerScienceStudent;
import model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class StudentDB3Test {

    @Test
    void getStudents() {
        Map<String, Student> ma=getStringStudentMap();
        StudentDB3 db=new StudentDB3(ma);

        System.out.println(db.getStudents());
        Assertions.assertTrue(ma.equals(db.getStudents()));
    }

    @Test
    void randomStudent() {
        StudentDB3 db = createDb3();
        for(int i=0;i<10;i++) {
            Student st=db.randomStudent();
            System.out.println(st);
            Assertions.assertNotNull(st);
        }
    }

    @Test
    void deleteStudent() {
        StudentDB3 db=createDb3();
        int len=db.getStudents().size();
//        Map<String, Student> map = db.getStudents();
//        Set<String> arr=map.keySet();
//        String[] strArr= arr.toArray(new String[0]);
        String id=db.getStudents().keySet().stream().toList().get(0);
        Assertions.assertTrue(db.deleteStudent(id));
        Assertions.assertTrue(len-1==db.getStudents().size());
    }

    @Test
    void addStudent() {
        StudentDB3 db=createDb3();
        int len=db.getStudents().size();
        Student stDouble=new BiologyStudent("Tina","346",new
                Address("StreetX 89", "Verona", "zui52"),122);
        db.addStudent(stDouble);
        Assertions.assertTrue(len+1==db.getStudents().size());
    }

    private StudentDB3 createDb3(){
        Map<String, Student> stMp = getStringStudentMap();
        return new StudentDB3(stMp);
    }

    private Map<String, Student> getStringStudentMap() {
        Map<String,Student> stMp=new HashMap<>();
        List<Student> students = Arrays.asList(
                new ComputerScienceStudent("Karl", "123"),
                new ComputerScienceStudent("Tina", "345"),
                new ComputerScienceStudent("Bob", "789"),
                new ComputerScienceStudent("Betty", "167")
        );

        for(Student st:students){
            ArrayList<Student> arraylist = new ArrayList<>(Arrays.asList(st));
            stMp.put(st.getId(),st);
        }
        return stMp;
    }
}