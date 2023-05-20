package kz.bitlab.spring.sprinttask1.db;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Nazerke", "Bisametova", 100, "A"));
        students.add(new Student(2L, "Aruzhan", "Bisametova", 48, "F"));
    }

    public static Long id = 3L;

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudents(Student student) {
        student.setId(id);
        students.add(student);
        id++;
    }


}
