import java.util.*;

class Student implements Person {
    private String id, name;
    private static List<Student> studentList = new ArrayList<>();
    private static final Set<String> accessibleAreas = new HashSet<>(Arrays.asList("Library", "Cafeteria"));

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        studentList.add(this);
    }

    public String getID() { return id; }
    public String getName() { return name; }

    public boolean hasAccess(String area) {
        return accessibleAreas.contains(area);
    }

    public static void addStudent(String id, String name) {
        new Student(id, name);
        System.out.println("Added student: " + name);
    }
}

class Director implements Person {
    private String id, name;
    private static final Set<String> accessibleAreas = new HashSet<>(Arrays.asList("Office", "Library", "Cafeteria", "Meeting Room"));

    public Director(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }

    public boolean hasAccess(String area) {
        return accessibleAreas.contains(area);
    }
}

class Teacher implements Person {
    private String id, name;
    private static final Set<String> accessibleAreas = new HashSet<>(Arrays.asList("Library", "Classroom", "Cafeteria"));

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }

    public boolean hasAccess(String area) {
        return accessibleAreas.contains(area);
    }
}

class Janitor implements Person {
    private String id, name;
    private static final Set<String> accessibleAreas = new HashSet<>(Arrays.asList("Storage Room", "Cafeteria"));

    public Janitor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }

    public boolean hasAccess(String area) {
        return accessibleAreas.contains(area);
    }
}