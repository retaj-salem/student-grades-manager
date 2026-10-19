package com.retaj.studentgrades.util;

import com.retaj.studentgrades.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static final String DATA_FOLDER = "data";
    private static final String STUDENT_FILE = DATA_FOLDER + File.separator + "students.txt";

    private static void createFileIfNeeded() {
        try {
            File folder = new File(DATA_FOLDER);
            if (!folder.exists()) folder.mkdirs();

            File file = new File(STUDENT_FILE);
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static void addStudent(Student student) {
        createFileIfNeeded();
        try (PrintWriter output = new PrintWriter(new FileWriter(STUDENT_FILE, true))) {
            output.println(student.toFileLine());
        } catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }
    }

    public static List<Student> readStudents() {
        createFileIfNeeded();
        List<Student> students = new ArrayList<>();

        try (Scanner input = new Scanner(new File(STUDENT_FILE))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    students.add(new Student(parts[0], parts[1], parts[2], Double.parseDouble(parts[3])));
                }
            }
        } catch (Exception e) {
            System.out.println("Reading error: " + e.getMessage());
        }
        return students;
    }

    public static void saveAllStudents(List<Student> students) {
        createFileIfNeeded();
        try (PrintWriter output = new PrintWriter(STUDENT_FILE)) {
            for (Student student : students) {
                output.println(student.toFileLine());
            }
        } catch (IOException e) {
            System.out.println("Saving error: " + e.getMessage());
        }
    }

    public static Student findStudentById(String id) {
        for (Student student : readStudents()) {
            if (student.getId().equals(id)) return student;
        }
        return null;
    }
}
