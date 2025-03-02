import java.util.ArrayList;
import java.util.List;

public class AuditTrail {
    private static final AuditTrail instance = new AuditTrail();
    private final List<String> logs = new ArrayList<>();

    private AuditTrail() {}

    public static AuditTrail getInstance() {
        return instance;
    }

    public void log(String entry) {
        logs.add(entry);
        System.out.println("Log: " + entry);
    }
}
