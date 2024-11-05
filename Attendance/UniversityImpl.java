

package Attendance;

import java.util.*;

public class UniversityImpl implements University {
    private static final String TeacherFile = "Attendance/teachers.csv";
    private static final String ClassRoomFile = "Attendance/classroom.csv";

    @Override
    public void addTeacher(Teacher T) {
        String[] teacherData = {T.getName(),String.valueOf(T.getID()),String.valueOf(T.getMobile()),String.valueOf(T.getDOB()),T.getEmail(),T.getDpt(),"None",T.getRole(),T.getUserName(),T.getPassword(),String.valueOf(T.getAge())};
        CSVManager.writeToCSV(TeacherFile,teacherData,true);
        System.out.println("Teacher added Successfully");
    }
  
    public void removeTeacher(String TeacherID) {
        List<String[]> teachers = CSVManager.readFromCSV(TeacherFile);
        teachers.removeIf(teacher -> teacher[1].equals(TeacherID));
        CSVManager.writeAllToCSV(TeacherFile,teachers,false);
        System.out.println("Teacher Removed successfully");
    }

	public void addClass(ClassRoom CR) {
        String[] classroomData = {CR.getID(),CR.getName(),CR.getCapacity()};
        CSVManager.writeToCSV(ClassRoomFile, classroomData,true);
        System.out.println("classroom added Successfully");
    }

	public void removeClass(String classroomid) {
        List<String[]> classrooms = CSVManager.readFromCSV(ClassRoomFile);
        classrooms.removeIf(classroom -> classroom[0].equals(classroomid));
        CSVManager.writeAllToCSV(ClassRoomFile,classrooms,false);
        System.out.println("class Removed successfully");
    }
	
	public void viewAllTeachers() {
        List<String[]> teachers = CSVManager.readFromCSV(TeacherFile);
        System.out.println("Teachers List");
        for(String[] teacher:teachers) {
            System.out.println("ID: " + teacher[1] + " Name: " + teacher[0]);
        }
    }
	public void viewAllClassrooms() {

        List<String[]> classrooms = CSVManager.readFromCSV(ClassRoomFile);
        System.out.println("Class Rooms List");
        for(String[] classroom:classrooms) {
            System.out.println("ID: " + classroom[0] + " Name: " + classroom[1]);
        }
    }
}
