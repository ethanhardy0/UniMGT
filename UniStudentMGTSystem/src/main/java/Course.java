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
    private static int nextCourseID;
    
    public Course(String name, String building, String room, int capacity) {
        this.courseName = name;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        nextCourseID++;
    }
    
    public void enrolledStudent(Student newStudent) {
        
    }
    
    public boolean removeStudent(int studentID) {
        
        
        return false;
    }
    
    public void assignInstructor(Instructor newInstr) {
        this.courseInstructor = newInstr;
    }
    
    public void setCourseBldgRoom(String room) {
        this.courseBldgRoom = room; 
    }
    
    public void setCourseBuilding(String room) { // ??????/
        this.courseBuilding = room; 
    }
    
    public void setCapacity(int newCapacity) {
        this.courseCapacity = newCapacity; 
    }
    
    public void setCourseName(String name) {
        this.courseName = name; 
    }
    
    public String toString() {
        String str = "Course #: " + courseID + " Course: " + courseName + " Building: " + courseBuilding + " Room: " + courseBldgRoom
            + " Capacity: " + courseCapacity;
        return str;
    }
    
    public String getRoster() {
        
        
        return "";
    }
}
