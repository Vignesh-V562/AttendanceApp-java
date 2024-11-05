package Attendance;

class Admin extends Person{
    
    public Admin(String Name,int id,long Mobile,String DOB,String Email,Short age,String user,String pass) {
       super(Name,id,Mobile,DOB,Email,"Admin",age,user,pass);
    }

    public void addUser(String[] userData) {
        CSVManager.writeToCSV("Attendance/users.csv",userData,true);
        System.out.println("User adder successfully");
    }

    public void generateReport(String date) {
        AttendanceManager.generateReport(date);
    }

    public void removeUser(String userID) {
        boolean removed = CSVManager.removeFromCSV("Attendance/users.csv", userID);
        if(removed) {
            System.out.println("User with ID " + userID + " removed Successfully");
        }
        else {
             System.out.println("User with ID " + userID + " Not found.");
        }
    }
}