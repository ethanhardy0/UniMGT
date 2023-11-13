/**
 *
 * @author ethan
 */

import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseBuilding;
    private String courseBldgRoom;
    private int courseCapacity;
    private int courseID;
    private ArrayList<Student> enrolledStudents;
    private Instructor courseInstructor;
    private static int nextCourseID = 0;
    
    

    public Course(String name, String building, String room, int capacity) {
        this.courseName = name;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.courseID = nextCourseID;
        nextCourseID++;
        
    }
    
    public void enrolledStudent(Student newStudent) {
        enrolledStudents.add(newStudent);
    }

    public boolean removeStudent(int studentID) {
        int idToRemove = 0;
        for (Student student : enrolledStudents) {
            if (student.getStudentID() == studentID) {
                idToRemove = studentID - 1000;
                enrolledStudents.remove(idToRemove);
                return true;
            } 
        }
        return false; 
    }
    
    public void assignInstructor(Instructor newInstr) {
        this.courseInstructor = newInstr;
    }
    
    public void setCourseBldgRoom(String room) {
        this.courseBldgRoom = room; 
    }
    
    public void setCourseBuilding(String building) { 
        this.courseBuilding = building; 
    }
    
    public void setCapacity(int newCapacity) {
        this.courseCapacity = newCapacity; 
    }
    
    public void setCourseName(String name) {
        this.courseName = name; 
    }
    
    public String toString() {
        String str = "Course #: " + courseID + " Course: " + courseName + " Building: " + courseBuilding + " Room: " + courseBldgRoom
            + " Capacity: " + courseCapacity + " Instructor of Record: " + courseInstructor;
        return str;
    }
    
    public String getRoster() {
        StringBuilder str = new StringBuilder();

        // Chat helped make this
        for (Student student : enrolledStudents) {
            str.append(String.format("StudentID#: %s %s Major: %s Year:%s\n", 
                student.getStudentID(), student.getName(), student.getStudentMajor(), student.getStudentYear()));
        }
        return str.toString();

    }
}
