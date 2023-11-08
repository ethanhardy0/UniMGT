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
        int selection = 0; // String or int?
        
        // Loop for sending user to expected path
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
            }
            else {
                System.out.println("Please enter a valid menu option.");
            }
            
        return selection;
    }
    
    public static void createCourse() {
        // Scanner objects for course input --> separate data types for each instance variable 
        Scanner courseStr = new Scanner(System.in);
        Scanner courseInt = new Scanner(System.in);
        
        // Make new object with setters after getting scanner or Create new object with constructor?

        /* How will the program keep track of all courses made?
         - does putting course into the courseArrayList remove the need to keep track */

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
        // Scanner objects for student input 
        Scanner studentStr = new Scanner(System.in); 
        Scanner studentInt = new Scanner(System.in); 
        Scanner studentDouble = new Scanner(System.in); 

        // Output for filling student object with input
        System.out.println("Enter Student Information:");
        System.out.print("Name: ");
        String name = studentStr.nextLine(); 

        System.out.print("Major: ");
        String major = studentStr.nextLine(); 

        System.out.print("Year: ");
        int year = studentInt.nextInt(); 

        System.out.print("GPA: ");
        double GPA = studentDouble.nextDouble();

        System.out.print("Email: ");
        String email = studentStr.nextLine(); 


        // Instantiates a new student once input is received
        Student student = new Student(name, year, major, GPA, email); 

        studentArray.add(student); 
        System.out.println();

        // Link student to course -->
        System.out.println("Please Choose a Class: ");
        // Trying to print course objects held in courseArray
        System.out.println(courseArray.toString());
        System.out.println("-------------------");
 
        System.out.println("Choose Class: ");
        int courseNum = studentInt.nextInt(); 
        courseArray.get(courseNum);
        // Send student to course.enrolledStudent --> enrolledStudents arrayList? not sure
        
    }

    public static void rmStudent() {
        // Scanner for input of which student to remove
        Scanner removalInt = new Scanner(System.in); 


        System.out.println("Please choose a class");
        // Trying to print out course objects held in courseArray
        // System.out.print(course.ToString());
        int courseNum = removalInt.nextInt(); 
        System.out.println("-------------------");
        System.out.println("Choose class #:" + courseNum);


        System.out.println("Please choose a student: ");
        // Trying to print out student objects held in studentArray
        studentArray.toString(); 
        System.out.print("Type ID of Student to Remove: ");
        int studentNum = removalInt.nextInt(); 
        // Link studentNum to studentID to remove student objects from the studentArray --> need to go through course class removeStudent()


        System.out.println("Student Successfully Removed!");

    }

    public static void addInstr() {
        Scanner instrStr = new Scanner(System.in); 
        Scanner instrInt = new Scanner(System.in); 

        // Output for filling instructor object with input
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

        // Link Instructor to Course -->
        // Trying to print out courseArray information + The instructor teaching it
        System.out.println("Choose a course for this Instructor");
        System.out.println(courseArray.toString());
        
        int courseNum = instrInt.nextInt();

        System.out.println("-------------------");
        System.out.println("Choose Class #: " + courseNum);
    }

    public static void printRoster() {
        // currently printing where student is stored --> how to display it?
        System.out.println(studentArray.get(0));
    }
    
}
