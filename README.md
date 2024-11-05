# AttendanceApp-java

ATTENDANCE MANAGEMENT MINI PROJECT USING BASIC OOP CONCEPTS IN JAVA 
                               By Vignesh. V

PROJECT STRUCTURE:
             Person (Base Class)
                - Admin      (Derived class from Person)
                - Teeacher   (Derived class from Person)
                - Student    (Derived class from Person)
             University (Interface) -> UniversityImpl (Class that Implements University interface)

CSV Files:
1.	attendance.csv
2.	classroom.csv
3.	teachers.csv
4.	users.csv

AttendanceApp.java:
	Main application to exhibit functionality of all classes.
Person.java:
	Base class that defines the basic attributes of a person and methods to get them.
Admin.java:
	Extends the base class Person and adds functionality for the admin i.e. adding and removing users, classrooms. etc
Student.java
Extends the base class Person and adds functionality for the student i.e. To view attendance.

Teacher.java:
Extends the base class Person and adds functionality for the Teacher i.e. Marking attendance for students.
University.java:
	This is an interface for the University class.
UniversityImpl.java:
	Implements the Interface University.
ClassRoom.java:
	Defines the attributes and methods for the classroom namely class name, ID, and capacity of class.
CSVManager.java:
	Contains all the file handling methods to read from and write to a csv file.
AttendanceManager.java:
	Defines methods for record/view attendance for a student, generate attendance report based on the date

WORKING EXPLANATION:

Authentication: 
The program starts by asking the user to enter their username and password. The authenticate method checks the username and password against a CSV file called "users.csv".     If the credentials are valid, the method returns a Person object representing the user.    	   
User Roles: 
There are three types of users: Admin, Teacher, and Student. Each user has their own menu with different options. The Person object returned by the authenticate method is cast to the corresponding user type (e.g., Admin, Teacher, or Student).
Admin Menu: 
The Admin menu has several options:
1.	Add Teacher: allows the admin to add a new teacher to the system.
2.	Remove Teacher: allows the admin to remove a teacher from the system.
3.	Add Classroom: allows the admin to add a new classroom to the system.
4.	Remove Classroom: allows the admin to remove a classroom from the system.
5.	View All Teachers: displays a list of all teachers in the system.
6.	View All Classrooms: displays a list of all classrooms in the system.
7.	Add User: allows the admin to add a new user (student or teacher) to the system.
8.	Remove User: allows the admin to remove a user from the system.
9.	Generate Report: generates a report of attendance for a specific date.
10.	Exit: exits the Admin menu.
Teacher Menu:
The Teacher menu has three options:
1.	Mark Attendance: allows the teacher to mark attendance for a specific student on a specific date.
2.	View All Students: displays a list of all students in the system.
3.	Exit: exits the Teacher menu.
Student Menu:
The Student menu has two options:
1.	View My Attendance: displays the student's attendance record.
2.	Exit: exits the Student menu.
