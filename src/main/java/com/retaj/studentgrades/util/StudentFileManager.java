package com.retaj.studentgrades.util;

import com.retaj.studentgrades.model.Student;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentFileManager {
    private static final String FILE_NAME = "data/students.txt";

    public static ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                Student student = Student.fromFileLine(input.nextLine());
                if (student != null) {
                    students.add(student);
                }
            }
        } catch (Exception ex) {
            System.out.println("File reading error: " + ex.getMessage());
        }
        return students;
    }

    public static void saveStudents(ArrayList<Student> students) {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (PrintWriter output = new PrintWriter(FILE_NAME)) {
            for (Student student : students) {
                output.println(student.toFileLine());
            }
        } catch (Exception ex) {
            System.out.println("File writing error: " + ex.getMessage());
        }
    }

    public static void addStudent(Student student) {
        ArrayList<Student> students = readStudents();
        students.add(student);
        saveStudents(students);
    }

    public static boolean updateGrade(String id, double grade) {
        ArrayList<Student> students = readStudents();
        boolean found = false;

        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setGrade(grade);
                found = true;
                break;
            }
        }

        if (found) {
            saveStudents(students);
        }
        return found;
    }

    public static double calculateAverage() {
        ArrayList<Student> students = readStudents();
        if (students.isEmpty()) return 0;

        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }
}
