public class Student implements Person {
    private final String id, name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public String getRole() { return "Student"; }
}
