class Student {
    protected String studentID;
    protected String name;
    protected String grade;

    public Student(String studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Student: " + name + " (ID: " + studentID + "), Grade: " + grade);
    }
}

class RegularStudent extends Student {
    public RegularStudent(String studentID, String name, String grade) {
        super(studentID, name, grade);
    }
}

class SpecialStudent extends Student {
    private String specialProgram;

    public SpecialStudent(String studentID, String name, String grade, String specialProgram) {
        super(studentID, name, grade);
        this.specialProgram = specialProgram;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Program: " + specialProgram);
    }
}