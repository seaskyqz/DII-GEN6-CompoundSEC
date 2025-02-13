// Interface สำหรับกำหนดโครงสร้างของข้อมูลนักเรียน
interface StudentInfo {
    String getStudentID();
    String getName();
    String getGrade();
    void displayInfo();
}

// คลาสสำหรับนักเรียนทั่วไป
class RegularStudent implements StudentInfo {
    private String studentID;
    private String name;
    private String grade;

    public RegularStudent(String studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    @Override
    public void displayInfo() {
        System.out.println("Regular Student: " + name + " (ID: " + studentID + "), Grade: " + grade);
    }
}

// คลาสสำหรับนักเรียนพิเศษ
class SpecialStudent implements StudentInfo {
    private String studentID;
    private String name;
    private String grade;
    private String specialProgram;

    public SpecialStudent(String studentID, String name, String grade, String specialProgram) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
        this.specialProgram = specialProgram;
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    public String getSpecialProgram() {
        return specialProgram;
    }

    @Override
    public void displayInfo() {
        System.out.println("Special Student: " + name + " (ID: " + studentID + "), Grade: " + grade + ", Program: " + specialProgram);
    }
}