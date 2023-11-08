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
    private static int nextStudentID;
    
    public Student(String name, int year, String major, double GPA, String email) {
        this.firstName = name; 
        this.lastName = name; 
        // this.studentYear = year; // Do I change year to String or studentYear to int??
        this.studentMajor = major;
        this.GPA = GPA; 
        this.studentEmail = email; 
        // StudentID ???? --> this.studentID = nextStudentID 
        nextStudentID++;
    }
    
    public void setGPA(double GPA) {
        this.GPA = GPA; 
    }
    
    public double getGPA() {
        return GPA;
    }
    
    public String getName() {
        return firstName + lastName;
    }
    
    // may be good?
    public int getStudentID() {
        return studentID;
    }
    
    public void setStudentEmail(String email) {
        this.studentEmail = email; 
    }
    
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentYear(int year) {
        if (year == 1)
            this.studentYear = "Freshman"; 
        if (year == 2)
            this.studentYear = "Sophmore";
        if (year == 3)
            this.studentYear = "Junior";
        if (year == 4)
            this.studentYear = "Senior";
        if (year >= 5)
            this.studentYear = (year + "th Year");
        else
            this.studentYear = "Invalid Student Year";
    }    

    public String getStudentYear() {
        return studentYear;
    }
    
    public void setStudentMajor(String major) {
        this.studentMajor = major;
    }    
    
    public String getStudentMajor() {
        return studentMajor;
    }
    

}
