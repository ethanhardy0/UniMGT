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
    private int courseID = 0;
    private ArrayList<Student> enrolledStudents;
    private Instructor courseInstructor;
    private static int nextCourseID;
    

    public Course(String name, String building, String room, int capacity) {
        this.courseName = name;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        courseID = nextCourseID;
        nextCourseID++;
        
    }
    
    public void enrolledStudent(Student newStudent) {
        this.enrolledStudents = new ArrayList<>();
        enrolledStudents.add(newStudent);
    }
    
    public boolean removeStudent(int studentID) {
        if(studentID <= enrolledStudents.size()){
            enrolledStudents.remove(studentID);
            return true;
        } else {
            return false;
        }
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
            + " Capacity: " + courseCapacity + " ";
        return str;
    }
    
    public String getRoster() {
        return enrolledStudents.get(courseID).getStudentID() + " " + enrolledStudents.get(courseID).getName() + " " +
                enrolledStudents.get(courseID).getStudentMajor()+ " " + enrolledStudents.get(courseID).getStudentYear() ; 
    }
}
