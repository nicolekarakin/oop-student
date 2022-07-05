package model;

import java.util.Objects;

public abstract class Student {
    private String name;
    private String id;
    private Address address;

    public abstract String getSubject();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
