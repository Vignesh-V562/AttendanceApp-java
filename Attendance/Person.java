
package Attendance;

import java.time.*;
import java.util.*;

class Person {
    protected String Name;
    protected int ID;
    protected long Mobile;
    protected String DOB;
    protected String Email;
    protected String Role;
    protected short age;
    protected String Username;
    protected String password;

    public Person(String Name, int id,long Mobile,String DOB,String Email, String Role,Short age, String user,String pass) {
        this.Name = Name;
        this.ID = id;
        this.Mobile = Mobile;
        this.DOB = DOB;
        this.Email = Email;
        this.Role = Role;
        this.age = age;
        this.Username = user;
        this.password = pass;
    }

    public String getName() {
        return this.Name;
    }
    
    public int getID() { return this.ID; }

    public long getMobile() { return this.Mobile; }

    public String getDOB() {return this.DOB; }
    
    public String getEmail() { return this.Email; }

    public String getRole() {
        return this.Role;
    }
    
    public short getAge() { return this.age; }
    
    public String getUserName() {
        return this.Username;
    }
    
    public String getPassword() {
        return this.password;
    }

}