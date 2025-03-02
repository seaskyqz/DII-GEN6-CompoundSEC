public class Janitor implements Person {
    private final String id, name;

    public Janitor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public String getRole() { return "Janitor"; }
}
