package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for(Student student : students)
            if(averageGrade == student.getAverageGrade())
                return student;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        int posMaxAverageGrade = 0;
        for(int i = 1; i < students.size(); i++)
            if(students.get(i).getAverageGrade() > students.get(posMaxAverageGrade).getAverageGrade())
                posMaxAverageGrade = i;
        return students.isEmpty() ? null : students.get(posMaxAverageGrade);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        int posMinAverageGrade = 0;
        for(int i = 1; i < students.size(); i++)
            if(students.get(i).getAverageGrade() < students.get(posMinAverageGrade).getAverageGrade())
                posMinAverageGrade = i;
        return students.isEmpty() ? null : students.get(posMinAverageGrade);
    }

    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }
}
