package Attendance;

public class Student extends Person {
    private String className;
    public Student(String Name,int id,long Mobile,String className,String DOB,String Email,Short age,String user,String pass) {
       super(Name,id,Mobile,DOB,Email,"student",age,user,pass);
       this.className = className;
    }
    public String getClassName() {
        return this.className;
    }
    
    public void viewMyAttendence(){
        AttendanceManager.viewAttendanceForStudent(String.valueOf(this.ID));
    }
}