/**
 * PA 6: University Student Management System
 * System to create courses, add instructors, and add/remove students 
 *
 * @author Ethan Hardy, Jacob Carney, Brian Thomas
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Student> studentArray = new ArrayList<>();
    public static ArrayList<Course> courseArray = new ArrayList<>();
    public static ArrayList<Instructor> instructorArray = new ArrayList<>();
    private static int courseNum;

    public static void main(String[] args) {
        int selection = 0; 
        
        // Loop for menu
        do { 
            selection = printMenu(selection);
        
            switch (selection) {
                case (1) : { // Create a Course
                    createCourse();
                    break;
                }
                case (2) : { // Add student to Course
                    addStudent(); 
                    break;
                }
                case (3) : { // Remove student from a Course
                    rmStudent();
                    break;
                }
                case (4) : { // Add instructor to a Course
                    addInstr();
                    break;
                }
                case (5) : { // Print Roster for a Course
                    printRoster();
                    break;
                }
                default : {
                    break;
                }
            }
        } while (selection != 6);
    }

// Method for printing and validating the menu for the system
    public static int printMenu(int selection) {
        Scanner sel = new Scanner(System.in);
        
        System.out.print("""
                          Student Management System
                          Please make a menu choice below:
                          --------------------------------
                          1. Create a Course
                          2. Add student to Course
                          3. Remove student from a Course
                          4. Add instructor to a Course
                          5. Print Roster for a Course
                          6. Quit
                          Choice:  """);
            
    // Validates menu choice
        if (sel.hasNextInt()) {
            selection = sel.nextInt();  
            if (selection == 6) {
                System.out.println("Exiting Menu...");
            }
            if (selection > 6 || selection < 0) {
            System.out.println("Please enter a valid menu option.\n");
            return 0;
            }
            return selection;
        }
        else {
            System.out.println("Please enter a valid menu option.\n");
            return 0;
        }
    }
    
// Method for creating courses
    public static void createCourse() {
    // Scanner objects for course input
        Scanner courseStr = new Scanner(System.in);
        Scanner courseInt = new Scanner(System.in);

    // Collects parameters to fill a course object
        System.out.println("Creating Class...");
        System.out.print("Enter a Course Name: ");
        String name = courseStr.nextLine();
                
        System.out.print("Enter Building: ");
        String building = courseStr.nextLine(); 
        
        System.out.print("Enter Room Number: ");
        String room = courseStr.nextLine();
        
        System.out.print("Enter Room Capacity: ");
        int capacity = courseInt.nextInt(); 

        
    // Instantiates a new course once input is received
        Course course = new Course(name, building, room, capacity); 
        courseArray.add(course);
        System.out.println();
    }

// Method for adding students to courses
    public static void addStudent() {
    // Checks if there are courses
        if (courseArray.isEmpty()) {
            System.out.println("Please enter a course to add a student!\n");
            return;
        }

    // Scanner objects for student input 
        Scanner studentStr = new Scanner(System.in); 
        Scanner studentInt = new Scanner(System.in); 
        Scanner studentDouble = new Scanner(System.in); 
        
    // Fills student object
        System.out.println("Enter Student Information:");
        System.out.print("Name: ");
        String name = studentStr.nextLine(); 
        Student student = new Student(name);

        System.out.print("Major: ");
        String major = studentStr.nextLine(); 
        student.setStudentMajor(major);
        
        System.out.print("Year: ");
        int year = studentInt.nextInt(); 
    // Checks if year is valid
        while (year < 1 || year > 4) {
            System.out.println("Not an available year!");
            System.out.print("Year:");
            year = studentInt.nextInt();
        }
        student.setStudentYear(year);

        System.out.print("GPA: ");
        double GPA = studentDouble.nextDouble();
    // Checks if GPA is in-range
        while (GPA < 0 || GPA > 5) {
            System.out.println("Invalid GPA!");
            System.out.print("GPA: ");
            GPA = studentDouble.nextDouble();
        }
        student.setGPA(GPA);             

        System.out.print("Email: ");
        String email = studentStr.nextLine();
    // Checks if email can be accepted 
        while (!email.contains("@")){
            System.out.println("Enter a valid email address! Make sure you use an @ symbol!");
            System.out.println("Email: ");
            email = studentStr.nextLine();
        }
        student.setStudentEmail(email);

    // Adds students to the student array
        studentArray.add(student); 
        System.out.println();

    // Prints available courses
        printCourses();

    // Assigns student to course
        Course selectedCourse = courseArray.get(courseNum);
        selectedCourse.enrolledStudent(student);
        System.out.println();

    }

// Method for removing a student from a course
    public static void rmStudent() {
    // Scanner for input of which student to remove
        Scanner scan = new Scanner(System.in); 
    
    // Checks if there are courses 
        if (courseArray.isEmpty()) {
            System.out.println("Cannot remove students if there are no courses!\n");
            return;
        }
    // Checks if there are students
        if (studentArray.isEmpty()) {
            System.out.println("Cannot remove a student if there are no students enrolled\n");
            return;
        }
    // Prints courses in the system    
        printCourses();

    // Prints students in a class
        System.out.println("Please choose a student: ");
        System.out.println(courseArray.get(courseNum).getRoster());
        System.out.print("Type ID of Student to Remove: ");
        int studentNum = scan.nextInt(); 
    
    // Removes a student from the course array
        boolean remove = courseArray.get(courseNum).removeStudent(studentNum);
    
    // Validates whether a student has been removed
        if (remove == false)
            System.out.println("Student not found\n");
        else 
            System.out.println("Student Successfully Removed!\n");
    }

// Method for adding an instructor to a course
    public static void addInstr() {
    // Checks if there are courses 
        if (courseArray.isEmpty()) {
            System.out.println("Cannot add instructor to courses if there are no courses!\n");
            return;
        }

        Scanner instrStr = new Scanner(System.in); 
        Scanner instrInt = new Scanner(System.in); 

    // Collects parameters to fill an instructor object
        System.out.println("Enter Instructor Information:");
        System.out.print("Name: ");
        String name = instrStr.nextLine();

        System.out.print("Prefix: ");
        String prefix = instrStr.nextLine();

        System.out.print("Office: ");
        String office = instrStr.nextLine();

        System.out.print("Department: ");
        String dept = instrStr.nextLine();

        System.out.print("Email: ");
        String email = instrStr.nextLine();


    // Instantiates a new instructor once input is received
        Instructor instructor = new Instructor(name, prefix, office, dept, email);

        instructorArray.add(instructor);
        System.out.println();

    // Prints courses available to instructors
        printCourses();
    
    // Assigns instructor to a course
        courseArray.get(courseNum).assignInstructor(instructor);
        System.out.println();
    }

// Method for printing the students for a course
    public static void printRoster() {
    // Checks if there are courses 
        if (courseArray.isEmpty()) {
            System.out.println("Enter a course first!\n");
            return;
        }
        
    // Prints courses in the system
        printCourses();
        
    // Prints students in a given class
        System.out.println(courseArray.get(courseNum).getRoster());
    }

// Prints the courses stored in the system
    public static void printCourses() {
        Scanner scan = new Scanner(System.in);

    // Prints courses stored in courseArray
        System.out.println("Please Choose a class: ");
        for (int i = 0; i < courseArray.size(); i ++) {
            System.out.println(courseArray.get(i));
        }
            
        System.out.print("Choose Class# ");
        courseNum = scan.nextInt();
    // Validates if course number selected exists
        while (courseNum < 0 || courseNum > courseArray.size()) {
            System.out.println("Invalid class #\n");
            System.out.print("Choose Class# ");
            courseNum = scan.nextInt();
        }
        System.out.println();
    }
}
