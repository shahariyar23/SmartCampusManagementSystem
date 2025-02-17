# Smart Campus Management System

A simple Java-based Smart Campus Management System (SCMS) designed to manage students, courses, attendance, and campus events efficiently.

## Features

1. **Student Management**:
   - Add, view, update, and delete student records.

2. **Course Management**:
   - Add, view, and assign courses to students.

3. **Attendance Tracker**:
   - Record and view attendance for students.

4. **Event Notification System**:
   - Add and view campus events.

5. **User-Friendly Menu**:
   - Navigate through the system using a console-based menu interface.

---

## How to Run

### Prerequisites

- Java Development Kit (JDK) installed (version 8 or above).
- A code editor or IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/smart-campus-management-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd smart-campus-management-system
   ```

3. Compile the code:
   ```bash
   javac SmartCampusManagementSystem.java
   ```

4. Run the program:
   ```bash
   java SmartCampusManagementSystem
   ```

---

## Usage

When you run the program, you'll see the main menu with the following options:

1. **Manage Students**:
   - Add students by entering their ID, name, and department.
   - View all registered students.
   - Update student details.
   - Delete a student.

2. **Manage Courses**:
   - Add new courses by providing a course ID and name.
   - View all available courses and their enrolled students.
   - Assign courses to students.

3. **Attendance Tracker**:
   - Record attendance for a specific student in a course.
   - View all attendance records by student and course.

4. **Event Notification System**:
   - Add events with a title, date, and description.
   - View all campus events.

5. **Exit**:
   - Quit the application.

---

## Code Structure

The program is organized into the following classes:

- **`Student`**:
  Represents a student with an ID, name, department, and enrolled courses.

- **`Course`**:
  Represents a course with an ID, name, and list of enrolled students.

- **`Event`**:
  Represents an event with a title, date, and description.

- **Main Program**:
  Handles menu-driven interactions, student management, course management, attendance tracking, and event notifications.

---

## Example Output

```
--- Smart Campus Management System (SCMS) ---
1. Manage Students
2. Manage Courses
3. Attendance Tracker
4. Event Notification System
5. Exit
Choose an option: 1

--- Student Management ---
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Back to Main Menu
Choose an option: 1

Enter Student ID: S001
Enter Name: John Doe
Enter Department: Computer Science
Student added successfully.
```

---

## Future Enhancements

- Implement a database for data persistence.
- Add a graphical user interface (GUI) for improved user experience.
- Enable login and role-based access for students, faculty, and administrators.
- Add a reporting module to generate analytics and reports.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contribution

Contributions are welcome! Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

---

## Author

**Your Name**  
[GitHub Profile](https://github.com/yourusername)

---

Happy coding!

