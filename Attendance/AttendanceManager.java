package Attendance;

import java.util.*;

public class AttendanceManager {
    private static final String ATTENDANCE_FILE = "Attendance/attendance.csv";

    public static void recordAttendance(String studentId, String date, String session, String status) {
        String[] attendanceData = {studentId, date, session, status};
        CSVManager.writeToCSV(ATTENDANCE_FILE, attendanceData,true);
        System.out.println("Attendance recorded.");
    }

    public static void viewAttendanceForStudent(String studentId) {
        List<String[]> records = CSVManager.readFromCSV(ATTENDANCE_FILE);
        System.out.println("Attendance records for Student ID: " + studentId);
        for (String[] record : records) {
            if (record[0].equals(studentId)) {
                System.out.println("Date: " + record[1] + ", Session: " + record[2] + ", Status: " + record[3]);
            }
        }
    }

    public static void generateReport(String date) {
        List<String[]> records = CSVManager.readFromCSV(ATTENDANCE_FILE);
        System.out.println("Attendance report for Date: " + date);
        for (String[] record : records) {
            if (record[1].equals(date)) {
                System.out.println("Student ID: " + record[0] + ", Session: " + record[2] + ", Status: " + record[3]);
            }
        }
    }
}