import java.util.ArrayList;
import java.util.List;

class AuditTrail {
    private static AuditTrail instance;
    private List<String> logs = new ArrayList<>();

    private AuditTrail() {}

    public static AuditTrail getInstance() {
        if (instance == null) {
            instance = new AuditTrail();
        }
        return instance;
    }

    public void log(String entry) {
        logs.add(entry);
        System.out.println("Log: " + entry);
    }
}