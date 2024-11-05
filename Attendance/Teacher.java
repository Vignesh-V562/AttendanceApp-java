package Attendance;

class Teacher extends Person {
    private String Department;
    public Teacher(String Name,int id,long Mobile,String depart,String DOB,String Email,Short age,String user,String pass) {
       super(Name,id,Mobile,DOB,Email,"Teacher",age,user,pass);
       this.Department = depart;
    }
    public String getDpt() {
        return this.Department;
    }

    public void MarkAttendance(String studentID,String date,String session, String status) {
        AttendanceManager.recordAttendance(studentID,date,session,status);
    }
}