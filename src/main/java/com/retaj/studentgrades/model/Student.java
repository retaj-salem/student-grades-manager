package com.retaj.studentgrades.model;

public class Student {
    private String id;
    private String name;
    private String major;
    private double grade;

    public Student(String id, String name, String major, double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public double getGrade() { return grade; }

    public void setGrade(double grade) { this.grade = grade; }

    public static Student fromFileLine(String line) {
    String[] data = line.split(",");

    return new Student(
        data[0],                     // id
        data[1],                     // name
        data[2],                     // major
        Double.parseDouble(data[3])  // grade
    );
}
    
    public String toFileLine() {
        return id + "," + name + "," + major + "," + grade;
    }
}
