interface Student {
    String getID();
    String getName();
    String getGrade();
    boolean hasAccess();
}
class RegularStudent implements Student {
    private String id, name, grade;

    public RegularStudent(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public boolean hasAccess() { return true; }
}

class SpecialStudent extends RegularStudent {
    public SpecialStudent(String id, String name, String grade) {
        super(id, name, grade);
    }

    @Override
    public boolean hasAccess() { return true; }
}