package db;

import model.Student;

import java.util.Map;

public class StudentDB3 {
    private Map<String, Student> students;

    public StudentDB3(Map<String, Student> students) {
        this.students = students;
    }

    public StudentDB3() {

    }

    public Map<String,Student> getStudents() {
        return students;
    }

    public Student randomStudent() {
        int rand = (int) (Math.random() * students.size());
        return students.get(students.keySet().toArray()[rand]);
    }

    public boolean deleteStudent(String studentIdToDelete) {
        Student removed=students.remove(studentIdToDelete);
        return removed!=null;
    }

    public void addStudent(Student student){
        if(student!=null)
        students.put(student.getId(),student);
    }

}
