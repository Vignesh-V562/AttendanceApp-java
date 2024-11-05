package Attendance;

import java.util.List;
import java.util.Scanner;

public class AttendanceApp {
    private static final University university = new UniversityImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate user and determine role
        Person user = authenticate(username, password);

        if (user == null) {
            System.out.println("Invalid credentials. Access denied.");
        } else if (user instanceof Admin) {
            System.out.println("Welcome, Admin " + user.getName() + "!");
            adminMenu((Admin) user, scanner);
        } else if (user instanceof Teacher) {
            System.out.println("Welcome, Teacher " + user.getName() + "!");
            teacherMenu((Teacher) user, scanner);
        } else if (user instanceof Student) {
            System.out.println("Welcome, Student " + user.getName() + "!");
            studentMenu((Student) user, scanner);
        }

        scanner.close();
    }

    private static Person authenticate(String username, String password) {
        List<String[]> users = CSVManager.readFromCSV("Attendance/users.csv");
        for (String[] userData : users) {
            if (userData[8].equals(username) && userData[9].equals(password)) {
                String role = userData[7];
                switch (role) {
                    case "Admin":
                        return new Admin(userData[0], Integer.parseInt(userData[1]), Long.parseLong(userData[2]), userData[3], userData[4],Short.parseShort(userData[10]),userData[8],userData[9]);
                    case "Teacher":
                        return new Teacher(userData[0], Integer.parseInt(userData[1]), Long.parseLong(userData[2]),userData[5],userData[3], userData[4],Short.parseShort(String.valueOf(userData[10])), userData[8], userData[9]);
                    case "Student":
                        return new Student(userData[0], Integer.parseInt(userData[1]), Long.parseLong(userData[2]),userData[6],userData[3], userData[4],Short.parseShort(String.valueOf(userData[10])), userData[8], userData[9]);
                }
            }
        }
        return null;
    }

    private static void adminMenu(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:\n1. Add Teacher\n2. Remove Teacher\n3. Add Classroom\n4. Remove Classroom\n5. View All Teachers\n6. View All Classrooms\n7. AddUser\n8. Remove User\n9. Generate Report\n0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Teacher ID: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter Teacher Name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    Long ph = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dpt = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    short age = scanner.nextShort();
                    scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    Teacher teacher = new Teacher(teacherName, Integer.parseInt(teacherId), ph, dpt, dob, email,age, username, password);
                    university.addTeacher(teacher);
                    break;

                case 2:
                    System.out.print("Enter Teacher ID to Remove: ");
                    teacherId = scanner.nextLine();
                    university.removeTeacher(teacherId);
                    break;

                case 3:
                    System.out.print("Enter Classroom ID: ");
                    String classroomId = scanner.nextLine();
                    System.out.print("Enter Classroom Name: ");
                    String classroomName = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    String capacity = scanner.nextLine();
                    ClassRoom classroom = new ClassRoom(classroomId, classroomName, capacity);
                    university.addClass(classroom);
                    break;

                case 4:
                    System.out.print("Enter Classroom ID to Remove: ");
                    classroomId = scanner.nextLine();
                    university.removeClass(classroomId);
                    break;

                case 5:
                    university.viewAllTeachers();
                    break;

                case 6:
                    university.viewAllClassrooms();
                    break;

                case 7:
                    System.out.print("Enter ID: ");
                    String Id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    ph = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    dpt = scanner.nextLine();
                    System.out.print("Enter Class name (if Student otherwise None): ");
                    String cn = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    dob = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter Role : ");
                    String role = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    age = scanner.nextShort();
                    scanner.nextLine();
                    System.out.print("Enter Username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    password = scanner.nextLine();

                    String[] data = {Name,String.valueOf(Id), String.valueOf(ph), dob, email,dpt,cn,role, username, password,String.valueOf(age)};
                    admin.addUser(data);
                    break;

                case 8:
                    System.out.print("Enter User ID to Remove: ");
                    String userId = scanner.nextLine();
                    admin.removeUser(userId);
                    break;

                case 9:
                    System.out.print("Enter Date (dd/mm/yy): ");
                    String date = scanner.nextLine();
                    admin.generateReport(date);
                    break;

                case 0:
                    System.out.println("Exiting Admin Menu...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void teacherMenu(Teacher teacher, Scanner scanner) {
        while (true) {
            System.out.println("\nTeacher Menu:\n1. Mark Attendance\n2. View All Students\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Date (dd/MM/yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Session: ");
                    String session = scanner.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = scanner.nextLine();
                    teacher.MarkAttendance(studentId, date, session, status);
                    break;

                case 2:
                    List<String[]> data = CSVManager.readFromCSV("Attendance/users.csv");
                    for(String[] user:data) {
                        if(user[7].equals("Student")) {
                            System.out.println("Name: " + user[0] + " ID: " + user[1] + " Age: " + user[10]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting Teacher Menu...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void studentMenu(Student student, Scanner scanner) {
        while (true) {
            System.out.println("\nStudent Menu:\n1. View My Attendance\n2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    student.viewMyAttendence();
                    break;

                case 2:
                    System.out.println("Exiting Student Menu...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}