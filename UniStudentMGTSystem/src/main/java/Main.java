/**
 *
 * @author ethan
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static ArrayList<Student> studentArray = new ArrayList<>();
    public static ArrayList<Course> courseArray = new ArrayList<>();
    public static ArrayList<Instructor> instructorArray = new ArrayList<>();

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
            
    // validates menu choice
        if (sel.hasNextInt()) {
            selection = sel.nextInt();  
            if (selection == 6) {
                System.out.println("Exiting Menu...");
            }
            return selection;
        }
        if (selection > 6) {
            System.out.println("Please enter a valid menu option.");
            return 0;
        }
        else {
            System.out.println("Please enter a valid menu option.");
            return 0;
        }
    }
    
    public static void createCourse() {
    // Scanner objects for course input --> separate data types for each instance variable 
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
    }

    public static void addStudent() {
    // Checks if there are courses
        if (courseArray.isEmpty()) {
            System.out.println("Please enter a course!");
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
        student.setStudentYear(year);

        System.out.print("GPA: ");
        double GPA = studentDouble.nextDouble();
        student.setGPA(GPA);

        System.out.print("Email: ");
        String email = studentStr.nextLine(); 
        student.setStudentEmail(email);


    // Adds students to the student array
        studentArray.add(student); 
        System.out.println();

    // Prints courses available to enroll a student
        System.out.println("Please Choose a Class: ");
    // Prints courses available
        System.out.println(courseArray.toString());
        System.out.println("-------------------");
    // Selects desired course
        System.out.print("Choose Class: ");
        int courseNum = studentInt.nextInt(); 

    // Assigns student to course
        Course selectedCourse = courseArray.get(courseNum);
        selectedCourse.enrolledStudent(student);

    }

    public static void rmStudent() {
    // Scanner for input of which student to remove
        Scanner scan = new Scanner(System.in); 
    
    // Checks if there are courses 
        if (courseArray.isEmpty()) {
            System.out.println("Enter a course first!");
            return;
        }
    // Checks if there are students
        if (studentArray.isEmpty()) {
            System.out.println("Cannot remove a student if there are no students enrolled");
            return;
        }
    // Prints courses in the system    
        System.out.println("Please choose a class");
        System.out.println(courseArray.toString()); 
        System.out.println("-------------------");
        System.out.print("Choose class #:");
        int courseNum = scan.nextInt();

    // Prints students in a class
        System.out.println("Please choose a student: ");
        System.out.println(courseArray.get(courseNum).getRoster());
        System.out.print("Type ID of Student to Remove: ");
        int studentNum = scan.nextInt(); 
    
    // Removes a student from the course array
        courseArray.get(courseNum).removeStudent(studentNum);
    
    // Validates whether a student has been removed
        if (courseArray.get(courseNum).removeStudent(studentNum))
            System.out.println("Student Successfully Removed!");
        else 
            System.out.println("Student not found");
    }

    public static void addInstr() {
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
        System.out.println("Choose a course for this Instructor");
        System.out.println(courseArray.toString());
        int courseNum = instrInt.nextInt();

        System.out.println("-------------------");
        System.out.print("Choose Class #: " + courseNum);
    
    // Assigns instructor to a course
        courseArray.get(courseNum).assignInstructor(instructor);
    }

    public static void printRoster() {
    // Scanner for choosing a course
        Scanner scan = new Scanner(System.in);
        
    // Prints courses in the system
        System.out.println("Please choose a class: ");
        courseArray.toString();
        System.out.print("Choose Class#: ");
        int courseNum = scan.nextInt();

    //Prints course roster of students
        System.out.println(courseArray.get(courseNum).getRoster());
        System.out.println();

    }

}

/*
Show arrays for rmStudent and printRoster - format them
Validate all user input
Add comments throughout code
Student and Instructor name not correct - first last
getTitle() --> what is use for it
 */
