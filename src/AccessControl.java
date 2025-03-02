import java.util.*;

public class AccessControl {
    private static final Map<String, Set<Floor>> floorAccess = new HashMap<>();
    private static final Map<String, Set<String>> roomAccess = new HashMap<>();

    static {
        floorAccess.put("S001", Set.of(Floor.LOW));
        floorAccess.put("T001", Set.of(Floor.LOW, Floor.MEDIUM));
        floorAccess.put("D001", Set.of(Floor.LOW, Floor.MEDIUM, Floor.HIGH));
        floorAccess.put("J001", Set.of(Floor.LOW));

        roomAccess.put("Student", Set.of("Library", "Cafeteria" ,"Classroom"));
        roomAccess.put("Teacher", Set.of("Library", "Classroom", "Cafeteria"));
        roomAccess.put("Director", Set.of("Office", "Library", "Cafeteria", "Meeting Room"));
        roomAccess.put("Janitor", Set.of("Storage Room", "Cafeteria"));
    }

    public static boolean hasAccess(Person user, Floor floor, String room) {
        boolean hasFloorAccess = floorAccess.getOrDefault(user.getID(), Set.of()).contains(floor);
        boolean hasRoomAccess = roomAccess.getOrDefault(user.getRole(), Set.of()).contains(room);
        return hasFloorAccess && hasRoomAccess;
    }
}
