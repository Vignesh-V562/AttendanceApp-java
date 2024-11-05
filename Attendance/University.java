


package Attendance;

public interface University {
	public void addTeacher(Teacher T);
	public void removeTeacher(String TeacherID);
	public void addClass(ClassRoom CR);
	public void removeClass(String classroom);
	public void viewAllTeachers();
	public void viewAllClassrooms();
}