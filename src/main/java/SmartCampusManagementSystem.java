
import java.util.*;
import java.text.SimpleDateFormat;
public class SmartCampusManagementSystem {
 static Scanner scanner = new Scanner(System.in);
 // Student class
 static class Student {
 String studentID;
 String name;
 String department;
 List<String> enrolledCourses;
 public Student(String studentID, String name, String department) {
 this.studentID = studentID;
 this.name = name;
 this.department = department;
 this.enrolledCourses = new ArrayList<>();
 }
 public void displayInfo() {
 System.out.println("ID: " + studentID + ", Name: " + name + ", Department: " +
department + ", Courses: " + enrolledCourses);
 }
 }
 // Course class
 static class Course {
 String courseID;
 String courseName;
 List<String> studentList;
 public Course(String courseID, String courseName) {
 this.courseID = courseID;
 this.courseName = courseName;
 this.studentList = new ArrayList<>();
 }
 }
 // Event class
 static class Event {
 String title;
 Date eventDate;
 String description;
 public Event(String title, Date eventDate, String description) {
 this.title = title;
 this.eventDate = eventDate;
 this.description = description;
 }
 public void displayEvent() {
 System.out.println("Title: " + title + ", Date: " + eventDate + ", Description: " +
description);
 }
 }
 static Map<String, Student> students = new HashMap<>();
 static Map<String, Course> courses = new HashMap<>();
 static List<Event> events = new ArrayList<>();
 static Map<String, Map<String, List<Date>>> attendance = new HashMap<>();
 public static void main(String[] args) {
 while (true) {
 System.out.println("\n--- Smart Campus Management System (SCMS) ---");
 System.out.println("1. Manage Students");
 System.out.println("2. Manage Courses");
 System.out.println("3. Attendance Tracker");
 System.out.println("4. Event Notification System");
 System.out.println("5. Exit");
 System.out.print("Choose an option: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // consume newline
 switch (choice) {
 case 1 -> manageStudents();
 case 2 -> manageCourses();
 case 3 -> attendanceTracker();
 case 4 -> eventNotificationSystem();
 case 5 -> {
 System.out.println("Exiting...");
 return;
 }
 default -> System.out.println("Invalid choice. Please try again.");
 }
 }
 }
 static void manageStudents() {
 while (true) {
 System.out.println("\n--- Student Management ---");
 System.out.println("1. Add Student");
 System.out.println("2. View Students");
 System.out.println("3. Update Student");
 System.out.println("4. Delete Student");
 System.out.println("5. Back to Main Menu");
 System.out.print("Choose an option: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // consume newline
 switch (choice) {
 case 1 -> addStudent();
 case 2 -> viewStudents();
 case 3 -> updateStudent();
 case 4 -> deleteStudent();
 case 5 -> { return; }
 default -> System.out.println("Invalid choice. Please try again.");
 }
 }
 }
 static void addStudent() {
 System.out.print("Enter Student ID: ");
 String id = scanner.nextLine();
 System.out.print("Enter Name: ");
 String name = scanner.nextLine();
 System.out.print("Enter Department: ");
 String department = scanner.nextLine();
 students.put(id, new Student(id, name, department));
 System.out.println("Student added successfully.");
 }
 static void viewStudents() {
 if (students.isEmpty()) {
 System.out.println("No students available.");
 return;
 }
 students.values().forEach(Student::displayInfo);
 }
 static void updateStudent() {
 System.out.print("Enter Student ID to update: ");
 String id = scanner.nextLine();
 if (!students.containsKey(id)) {
 System.out.println("Student not found.");
 return;
 }
 Student student = students.get(id);
 System.out.print("Enter New Name (or press Enter to keep unchanged): ");
 String name = scanner.nextLine();
 if (!name.isEmpty()) student.name = name;
 System.out.print("Enter New Department (or press Enter to keep unchanged): ");
 String department = scanner.nextLine();
 if (!department.isEmpty()) student.department = department;
 System.out.println("Student updated successfully.");
 }
 static void deleteStudent() {
 System.out.print("Enter Student ID to delete: ");
 String id = scanner.nextLine();
 if (students.remove(id) != null) {
 System.out.println("Student deleted successfully.");
 } else {
 System.out.println("Student not found.");
 }
 }
 static void manageCourses() {
 while (true) {
 System.out.println("\n--- Course Management ---");
 System.out.println("1. Add Course");
 System.out.println("2. View Courses");
 System.out.println("3. Assign Course to Student");
 System.out.println("4. Back to Main Menu");
 System.out.print("Choose an option: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // consume newline
 switch (choice) {
 case 1 -> addCourse();
 case 2 -> viewCourses();
 case 3 -> assignCourseToStudent();
 case 4 -> { return; }
 default -> System.out.println("Invalid choice. Please try again.");
 }
 }
 }
 static void addCourse() {
 System.out.print("Enter Course ID: ");
 String id = scanner.nextLine();
 System.out.print("Enter Course Name: ");
 String name = scanner.nextLine();
 courses.put(id, new Course(id, name));
 System.out.println("Course added successfully.");
 }
 static void viewCourses() {
 if (courses.isEmpty()) {
 System.out.println("No courses available.");
 return;
 }
 courses.values().forEach(course -> {
 System.out.println("ID: " + course.courseID + ", Name: " + course.courseName + ",Enrolled Students: " + course.studentList);
 });
 }
 static void assignCourseToStudent() {
 System.out.print("Enter Student ID: ");
 String studentID = scanner.nextLine();
 System.out.print("Enter Course ID: ");
 String courseID = scanner.nextLine();
 if (!students.containsKey(studentID)) {
 System.out.println("Student not found.");
 return;
 }
 if (!courses.containsKey(courseID)) {
 System.out.println("Course not found.");
 return;
 }
 Student student = students.get(studentID);
 Course course = courses.get(courseID);
 student.enrolledCourses.add(courseID);
 course.studentList.add(studentID);
 System.out.println("Course assigned successfully.");
 }
 static void attendanceTracker() {
 System.out.println("--- Attendance Tracker ---");
 System.out.println("1. Record Attendance");
 System.out.println("2. View All Attendance");
 System.out.print("Choose an option: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // consume newline
 switch (choice) {
 case 1 -> recordAttendance();
 case 2 -> viewAllAttendance();
 default -> System.out.println("Invalid choice. Please try again.");
 }
 }
 static void recordAttendance() {
 System.out.print("Enter Student ID: ");
 String studentID = scanner.nextLine();
 System.out.print("Enter Course ID: ");
 String courseID = scanner.nextLine();
 if (!students.containsKey(studentID) || !courses.containsKey(courseID)) {
 System.out.println("Invalid student or course ID.");
 return;
 }
 attendance.putIfAbsent(studentID, new HashMap<>());
 Map<String, List<Date>> studentAttendance = attendance.get(studentID);
 studentAttendance.putIfAbsent(courseID, new ArrayList<>());
 System.out.print("Would you like to record attendance for today? (yes/no): ");
 if (scanner.nextLine().equalsIgnoreCase("yes")) {
 studentAttendance.get(courseID).add(new Date());
 System.out.println("Attendance recorded.");
 } else {
 System.out.println("No attendance recorded.");
 }
 }
 static void viewAllAttendance() {
 if (attendance.isEmpty()) {
 System.out.println("No attendance records available.");
 return;
 }
 for (Map.Entry<String, Map<String, List<Date>>> studentEntry : attendance.entrySet()) {
 String studentID = studentEntry.getKey();
 System.out.println("Student ID: " + studentID);
 Map<String, List<Date>> courses = studentEntry.getValue();
 for (Map.Entry<String, List<Date>> courseEntry : courses.entrySet()) {
 String courseID = courseEntry.getKey();
 List<Date> dates = courseEntry.getValue();
 System.out.println(" Course ID: " + courseID);
 System.out.println(" Attendance Dates: " + dates);
 }
 }
 }
 static void eventNotificationSystem() {
 while (true) {
 System.out.println("\n--- Event Notification System ---");
 System.out.println("1. Add Event");
 System.out.println("2. View Events");
 System.out.println("3. Back to Main Menu");
 System.out.print("Choose an option: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // consume newline
 switch (choice) {
 case 1 -> addEvent();
 case 2 -> viewEvents();
 case 3 -> { return; }
 default -> System.out.println("Invalid choice. Please try again.");
 }
 }
 }
 static void addEvent() {
 System.out.print("Enter Event Title: ");
 String title = scanner.nextLine();
 System.out.print("Enter Event Date (yyyy-MM-dd): ");
 String dateInput = scanner.nextLine();
 System.out.print("Enter Event Description: ");
 String description = scanner.nextLine();
 try {
 Date eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
 events.add(new Event(title, eventDate, description));
 System.out.println("Event added successfully.");
 } catch (Exception e) {
 System.out.println("Invalid date format.");
 }
 }
 static void viewEvents() {
 if (events.isEmpty()) {
 System.out.println("No events available.");
 return;
 }
 events.forEach(Event::displayEvent);
 }
}