/**
 *
 * @author ethan
 */

public class Instructor {
    private String name;
    private String prefix;
    private String officeLocation;
    private String department;
    private String email;
    private int instructorID;
    private static int nextInstructID = 100;
    
    public Instructor(String name, String prefix, String office, String dept, String email) {
        this.name = name;
        this.prefix = prefix;
        this.officeLocation = office;
        this.department = dept;
        this.email = email; 
        this.instructorID = nextInstructID;
        nextInstructID++;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public void setDepartment(String dept) {
        this.department = dept;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setOfficeLocation(String office) {
        this.officeLocation = office; 
    }
    
    public String getTitle() {
        return this.prefix + " " + name;
    }
    
    public String toString() {
        String str = String.format("%s", getTitle());
        return str;
    }
}
