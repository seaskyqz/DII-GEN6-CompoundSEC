public class Teacher implements Person {
    private final String id, name;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public String getRole() { return "Teacher"; }
}
