import java.util.*;

class Student {
    private String stId;
    private String stName;
    private int prfMark;
    private int dbmsMark;
    private int stAge;
    private int contact;
    private String address;
    private String batch;
    private String subjectId;
    private String subjectName;

    public Student() {
        this.stId = null;
        this.stName = null;
        this.prfMark = -1;
        this.dbmsMark = -1;
        this.stAge = -1;
        this.contact = -1;
        this.address = null;
        this.batch = null;
        this.subjectId = null;
        this.subjectName = null;
    }

    public Student(String stId, String stName, int stAge, int contact, String address, String batch, String subjectId, String subjectName) {
        this.stId = stId;
        this.stName = stName;
        this.stAge = stAge;
        this.contact = contact;
        this.address = address;
        this.batch = batch;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getStId() { return stId; }
    public void setStId(String stId) { this.stId = stId; }

    public String getStName() { return stName; }
    public void setStName(String stName) { this.stName = stName; }

    public int getPrfMark() { return prfMark; }
    public void setPrfMark(int prfMark) { this.prfMark = prfMark; }

    public int getDbmsMark() { return dbmsMark; }
    public void setDbmsMark(int dbmsMark) { this.dbmsMark = dbmsMark; }

    public int getStAge() { return stAge; }
    public void setStAge(int stAge) { this.stAge = stAge; }

    public int getContact() { return contact; }
    public void setContact(int contact) { this.contact = contact; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBatch() { return batch; }
    public void setBatch(String batch) { this.batch = batch; }

    public String getSubjectId() { return subjectId; }
    public void setSubjectId(String subjectId) { this.subjectId = subjectId; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public double getTotalMark() {
        return prfMark + dbmsMark;
    }

    @Override
    public String toString() {
        return "\nStId: " + stId + "\nStName: " + stName + "\nPrfMark: " + prfMark + "\nDbmsMark: " + dbmsMark;
    }
}

class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
        this.subjectId = null;
        this.subjectName = null;
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() { return subjectId; }
    public void setSubjectId(String subjectId) { this.subjectId = subjectId; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    @Override
    public String toString() {
        return "Subject ID: " + subjectId + ", Subject Name: " + subjectName;
    }
}

class cw {
    private static Scanner input = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();
    private static List<Subject> subjectList = new ArrayList<>();
    
    public static void main(String[] args) {
        mainHomePage();
    }

    private static void clearConsole() {
        System.out.println("\n".repeat(50)); 
    }

    public static void mainHomePage() {
        //clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                STUDENT MANAGEMENT SYSTEM                    |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();
        System.out.println(" [1] Manage Student");
        System.out.println(" [2] Manage Subject Marks");
        System.out.println(" [3] Exit");
        System.out.println();
        System.out.print("Enter an option to continue > ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                ManageStudent();
                break;
            case 2:
                clearConsole();
                ManageSubMarks();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
                mainHomePage();
                break;
        }
    }

    public static void ManageStudent() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                       MANAGE STUDENT                        |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();
        System.out.println(" [1] Add New Student");
        System.out.println(" [2] Update Student");
        System.out.println(" [3] View Student");
        System.out.println(" [4] Main");
        System.out.println(" [5] Exit");
        System.out.println();
        System.out.print("Enter an option to continue > ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                AddNewStudent();
                break;
            case 2:
                clearConsole();
                UpdateStudentDetails();
                break;
            case 3:
                clearConsole();
                PrintStudentDetails();
                break;
            case 4:
                clearConsole();
                mainHomePage();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
                ManageStudent();
                break;
        }
    }

    public static void AddNewStudent() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                         ADD NEW STUDENT                     |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();

        System.out.print("Enter Student ID: ");
        String id = input.next();

        for (Student s : studentList) {
            if (id.equals(s.getStId())) {
                System.out.println("Student ID already exists");
                System.out.print("Do you want to add another student (Y/N)? ");
                String yn = input.next();
                if (yn.equalsIgnoreCase("Y")) {
                    AddNewStudent();
                } else {
                    ManageStudent();
                }
                return;
            }
        }

        Student newStudent = new Student();
        newStudent.setStId(id);

        System.out.print("Enter Student Name: ");
        String stName = input.next();
        newStudent.setStName(stName);

        System.out.print("Enter Age: ");
        int stAge = input.nextInt();
        newStudent.setStAge(stAge);

        System.out.print("Enter Contact Number: ");
        int stContact = input.nextInt();
        newStudent.setContact(stContact);

        System.out.print("Enter Address: ");
        input.nextLine(); 
        String stAddress = input.nextLine();
        newStudent.setAddress(stAddress);

        System.out.print("Enter Batch: ");
        String batch = input.next();
        newStudent.setBatch(batch);

        studentList.add(newStudent);

        System.out.println();
        System.out.print("Student has been added successfully. Do you want to add a new student (Y/N)? ");
        String yn = input.next();

        if (yn.equalsIgnoreCase("Y")) {
            AddNewStudent();
        } else {
            ManageStudent();
        }
    }
    public static void UpdateStudentDetails() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                       UPDATE STUDENT                        |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();
    
        System.out.print("Enter Student ID: ");
        String stId = input.next();
        Student studentToUpdate = null;
    
        for (Student s : studentList) {
            if (stId.equals(s.getStId())) {
                studentToUpdate = s;
                break;
            }
        }
    
        if (studentToUpdate == null) {
            System.out.println("Invalid Student ID. Do you want to search again (y/n)? ");
            String yn = input.next();
    
            if (yn.equalsIgnoreCase("y")) {
                UpdateStudentDetails();
            } else {
                clearConsole();
                mainHomePage();
            }
        } else {
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------------+");
            System.out.println("|                         CURRENT STUDENT DETAILS                             |");
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            System.out.println("| ID             | Name             | Address        | Contact| Age  | Batch  |");
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            System.out.printf("| %-14s | %-16s | %-14s | %-6s | %-4d | %-6s |\n",
                              studentToUpdate.getStId(),
                              studentToUpdate.getStName(),
                              studentToUpdate.getAddress(),
                              studentToUpdate.getContact(),
                              studentToUpdate.getStAge(),
                              studentToUpdate.getBatch());
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            System.out.println();
    
            System.out.println("Enter the detail to update (ID, Name, Age, Contact, Address, Batch): ");
            String detailToUpdate = input.next();
    
            switch (detailToUpdate.toLowerCase()) {
                case "id":
                    System.out.print("Enter new ID: ");
                    studentToUpdate.setStId(input.next());
                    break;
                case "name":
                    System.out.print("Enter new Name: ");
                    studentToUpdate.setStName(input.next());
                    break;
                case "age":
                    System.out.print("Enter new Age: ");
                    studentToUpdate.setStAge(input.nextInt());
                    break;
                case "contact":
                    System.out.print("Enter new Contact: ");
                    studentToUpdate.setContact(input.nextInt());
                    break;
                case "address":
                    System.out.print("Enter new Address: ");
                    input.nextLine(); 
                    studentToUpdate.setAddress(input.nextLine());
                    break;
                case "batch":
                    System.out.print("Enter new Batch: ");
                    studentToUpdate.setBatch(input.next());
                    break;
                default:
                    System.out.println("Invalid detail. Returning to Manage Student menu.");
                    ManageStudent();
                    return;
            }
    
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------------+");
            System.out.println("|                          UPDATED STUDENT DETAILS                            |");
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            System.out.println("| ID             | Name             | Address        | Contact| Age  | Batch  |");
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            System.out.printf("| %-14s | %-16s | %-14s | %-6s | %-4d | %-6s |\n",
                              studentToUpdate.getStId(),
                              studentToUpdate.getStName(),
                              studentToUpdate.getAddress(),
                              studentToUpdate.getContact(),
                              studentToUpdate.getStAge(),
                              studentToUpdate.getBatch());
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            System.out.println();
    
            System.out.print("Do you want to update another student (Y/N)? ");
            String yn = input.next();
    
            if (yn.equalsIgnoreCase("Y")) {
                UpdateStudentDetails();
            } else {
                ManageStudent();
            }
        }
    }
    
    public static void PrintStudentDetails() {
        clearConsole();
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.println("|                                VIEW STUDENT                                 |");
        System.out.println("+----------------+------------------+----------------+--------+------+--------+");
        System.out.println("| ID             | Name             | Address        | Contact| Age  | Batch  |");
        System.out.println("+----------------+------------------+----------------+--------+------+--------+");
        
        if (studentList.isEmpty()) {
            System.out.println("| No students found.                                    |");
            System.out.println("+----------------+------------------+----------------+--------+------+--------+");
        } else {
            for (Student student : studentList) {
                System.out.printf("| %-14s | %-16s | %-14s | %-6s | %-4d | %-6s |\n", 
                                  student.getStId(),
                                  student.getStName(),
                                  student.getAddress(),
                                  student.getContact(),
                                  student.getStAge(),
                                  student.getBatch());
                System.out.println("+----------------+------------------+----------------+--------+------+--------+");
            }
        }
    
        System.out.print("Do you want to view another student (Y/N)? ");
        String yn = input.next();
    
        if (yn.equalsIgnoreCase("Y")) {
            PrintStudentDetails();
        } else {
            ManageStudent();
        }
    }
    
    public static void ManageSubMarks() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                   MANAGE SUBJECT MARKS                      |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();
        System.out.println(" [1] Add Marks");
        System.out.println(" [2] Update Marks");
        System.out.println(" [3] View Marks");
        System.out.println(" [4] Main");
        System.out.println(" [5] Exit");
        System.out.println();
        System.out.print("Enter an option to continue > ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                AddMarks();
                break;
            case 2:
                clearConsole();
                UpdateMarks();
                break;
            case 3:
                clearConsole();
                ViewMarks();
                break;
            case 4:
                clearConsole();
                mainHomePage();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
                ManageSubMarks();
                break;
        }
    }

    public static void AddMarks() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                         ADD MARKS                           |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();

        System.out.print("Enter Student ID: ");
        String studentId = input.next();
        Student student = null;

        for (Student s : studentList) {
            if (s.getStId().equals(studentId)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found.");
            System.out.print("Do you want to add marks for another student (Y/N)? ");
            String yn = input.next();
            if (yn.equalsIgnoreCase("Y")) {
                AddMarks();
            } else {
                ManageSubMarks();
            }
            return;
        }

        System.out.print("Enter PRF Marks: ");
        int prfMark = input.nextInt();
        student.setPrfMark(prfMark);

        System.out.print("Enter DBMS Marks: ");
        int dbmsMark = input.nextInt();
        student.setDbmsMark(dbmsMark);

        System.out.println("Marks have been added successfully.");
        System.out.print("Do you want to add marks for another student (Y/N)? ");
        String yn = input.next();
        if (yn.equalsIgnoreCase("Y")) {
            AddMarks();
        } else {
            ManageSubMarks();
        }
    }

    public static void UpdateMarks() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                        UPDATE MARKS                         |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println();

        System.out.print("Enter Student ID: ");
        String studentId = input.next();
        Student student = null;

        for (Student s : studentList) {
            if (s.getStId().equals(studentId)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found.");
            System.out.print("Do you want to update marks for another student (Y/N)? ");
            String yn = input.next();
            if (yn.equalsIgnoreCase("Y")) {
                UpdateMarks();
            } else {
                ManageSubMarks();
            }
            return;
        }

        System.out.print("Enter new PRF Marks: ");
        int prfMark = input.nextInt();
        student.setPrfMark(prfMark);

        System.out.print("Enter new DBMS Marks: ");
        int dbmsMark = input.nextInt();
        student.setDbmsMark(dbmsMark);

        System.out.println("Marks have been updated successfully.");
        System.out.print("Do you want to update marks for another student (Y/N)? ");
        String yn = input.next();
        if (yn.equalsIgnoreCase("Y")) {
            UpdateMarks();
        } else {
            ManageSubMarks();
        }
    }
  



    public static void ViewMarks() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                               VIEW MARKS                                                                                         |");
        System.out.println("+--------------------+--------------------+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("| %-18s | %-18s | %-18s | %-18s | %-18s | %-18s | %-18s |\n", "ID", "Name", "   PRF Marks", "DBMS Marks", "Total Marks", "Average Marks", "Rank  |");
        System.out.println("+--------------------+--------------------+--------------------+--------------------+--------------------+--------------------+--------------------+");
    
        if (studentList.isEmpty()) {
            System.out.println("| No student marks found.                                    |");
            System.out.println("+------------------------------------------------------------+");
        } else {
            List<Student> sortedStudents = new ArrayList<>(studentList);
            sortedStudents.sort(Comparator.comparingDouble(Student::getTotalMark).reversed());
    
            int rank = 1;
            for (Student student : sortedStudents) {
                double averageMarks = (student.getPrfMark() + student.getDbmsMark()) / 2.0;
    
                System.out.printf("| %-18s | %-18s | %-18d | %-18d | %-18.2f | %-18.2f | %-18d |\n",
                        student.getStId(),
                        student.getStName(),
                        student.getPrfMark(),
                        student.getDbmsMark(),
                        student.getTotalMark(),
                        averageMarks,
                        rank++);
            }
            System.out.println("+--------------------+--------------------+--------------------+--------------------+--------------------+--------------------+--------------------+");
    
          
    
        System.out.print("Do you want to view marks for another student (Y/N)? ");
        String yn = input.next();
        if (yn.equalsIgnoreCase("Y")) {
            ViewMarks();
        } else {
            ManageSubMarks();
        }
    }
    
    
    




    }
}

