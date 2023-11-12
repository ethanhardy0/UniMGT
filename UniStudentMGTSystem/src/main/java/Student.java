/**
 *
 * @author ethan
 */

public class Student {
    private String firstName;
    private String lastName;
    private String studentYear;
    private String studentMajor;
    private double GPA;
    private String studentEmail;
    private int studentID;
    private static int nextStudentID = 1000;
    
    public Student(String name) {
        this.firstName = name;
        this.lastName = name;
        this.studentID = nextStudentID;
        nextStudentID++;
    }

    public Student(String name, int year, String major, double GPA, String email) {
        this.firstName = name; 
        this.lastName = name; 
        this.studentMajor = major;
        this.GPA = GPA; 
        this.studentEmail = email; 
        this.studentID = nextStudentID;
        nextStudentID++;
    }
    
    public void setGPA(double GPA) {
        this.GPA = GPA; 
    }
    
    public double getGPA() {
        return GPA;
    }
    
    public String getName() {
        return lastName + ", " + firstName;
    }
    
    public int getStudentID() {
        return this.studentID;
    }
      
    public void setStudentEmail(String email) {
        this.studentEmail = email; 
    }
    
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentYear(int year) {
        switch (year) {
            case (1) : 
                this.studentYear = "Freshman"; 
            case (2) :
                this.studentYear = "Sophmore";
            case (3) :
                this.studentYear = "Junior";
            case (4) :
                this.studentYear = "Senior";
            default :
                this.studentYear = "Invalid Student Year";
        }
    }    

    public String getStudentYear() {
        return this.studentYear;
    }
    
    public void setStudentMajor(String major) {
        this.studentMajor = major;
    }    
    
    public String getStudentMajor() {
        return studentMajor;
    }
}
