package db;

import model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDB2 {

    private Map<String, List<Student>> students;
    public StudentDB2(Map<String, List<Student>> allStudents) {
        students = allStudents;
    }

    public Map<String,List<Student>> getStudents() {
        return students;
    }

    public Student randomStudent() {
        Student randomStudent=null; int i=0;
        List<Student> flat =
                students.values().stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());

        int upperBound = flat.size();
        int rand = (int) (Math.random() * upperBound);

        for (var entry : students.entrySet()) {
            String name=entry.getKey();
            List<Student> studentsL=entry.getValue();
            for(int k=0;k<studentsL.size()&&randomStudent==null;k++){
                if(i==rand){
                    randomStudent=studentsL.get(k);
                }
                i++;
            }
        }
        return randomStudent;
    }

    public boolean deleteStudent(String studentIdToDelete) {
        List<Student> flat =
                students.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Optional<Student> studentToDelete =
                flat.stream().filter(a->a.getId().equals(studentIdToDelete)).findFirst();
        if(studentToDelete.isPresent()){
            List<Student> sameNamed=students.get(studentToDelete.get().getName());
            if(sameNamed.size()>1 && sameNamed.contains(studentToDelete.get())){
                sameNamed.remove(studentToDelete.get());
            }else {
                students.remove(studentToDelete.get().getName());
            }

            return true;
        }
        return false;
    }

    public void addStudent(Student student){
        if(students.get(student.getName())!=null){
            students.get(student.getName()).add(student);
        }
        else {
            ArrayList<Student> studentToAdd=new ArrayList<>();
            studentToAdd.add(student);
            students.put(student.getName(),studentToAdd);
        }
    }

    @Override
    public String toString() {
        //.forEach((key, value) -> System.out.println(key + " " + value));
        return students.toString();
    }
}
