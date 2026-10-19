<div align="center">

# 🎓 Student Grades Manager

**A JavaFX desktop application for managing students and their grades**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-21-4285F4?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

</div>

---

## 📖 About the Project

Student Grades Manager is a desktop application built with **Java and JavaFX** that lets an instructor log in, add students, record their grades, view all students, and see summary reports. Data is saved in a simple text file, so no database setup is needed.

## ✨ Features

- 🔐 Login screen
- 🏠 Dashboard to navigate between all screens
- ➕ Add new students (ID, name, major)
- 📝 Add or update a student's grade
- 📋 View all students in a table
- 📊 Reports: total number of students, average grade, and highest grade
- 💾 Data stored in a text file (`data/students.txt`)

## 🧰 Technologies

| Tool | Usage |
|------|-------|
| **Java 17+** | Main programming language |
| **JavaFX 21** | Graphical user interface (FXML + CSS) |
| **Maven** | Build and dependency management |
| **Text file storage** | Saving and loading student data |

## 🗂️ Project Structure

```
StudentGradesManager/
├── data/students.txt                 # Student data (id,name,major,grade)
├── pom.xml
└── src/main/
    ├── java/com/retaj/studentgrades/
    │   ├── MainApp.java              # Application entry point
    │   ├── controller/               # Login, Dashboard, AddStudent, AddGrades, ViewStudents, Reports
    │   ├── model/Student.java        # Student class
    │   └── util/                     # File handling and scene switching
    └── resources/                    # FXML screens and CSS style
```

## 🧠 How It Works

- **MVC-style structure:** the model (`Student`), the views (FXML files), and the controllers are separated.
- **File storage:** each student is saved as one line `id,name,major,grade`. `Student.fromFileLine()` and `toFileLine()` convert between the file and the object.
- **Scene switching:** a helper class loads the FXML screens and switches between them.

## 🚀 Getting Started

### Requirements
- JDK 17 or later
- Maven (or open the project in NetBeans / IntelliJ as a Maven project)

### Run
```bash
mvn clean javafx:run
```

### Demo login
```
Username: admin
Password: 1234
```
> These are demo credentials for this university project only. The sample data in `data/students.txt` is fictional.

## 🔮 Future Work

- Store data in a database (SQL) instead of a text file
- Secure login with hashed passwords and multiple users
- Edit and delete students
- Search and filter in the students table
- Export reports to PDF or Excel

---

<div align="center">

Made with ❤️ at Umm Al-Qura University

</div>
