import java.util.*;

// =====================
// PINEntry สำหรับการตรวจสอบ PIN ของผู้ใช้ (ลองผิดได้ 3 ครั้ง)
// =====================
class PINEntry {
    private static final int MAX_ATTEMPTS = 3;
    private final Map<String, Integer> failedAttempts = new HashMap<>();
    private final Set<String> lockedUsers = new HashSet<>();
    private final Map<String, String> userPins = Map.of(
            "S001", "0000", // นักเรียน
            "D001", "1111", // ผู้อำนวยการ
            "T001", "2222", // ครู
            "J001", "3333"  // ภารโรง
    );

    public boolean authenticate(String id) {
        Scanner scanner = new Scanner(System.in);

        // ตรวจสอบว่าผู้ใช้นี้ถูกล็อคหรือยัง
        if (lockedUsers.contains(id)) {
            System.out.println("Your account is locked due to too many failed attempts.");
            return false;
        }

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Enter PIN for " + id + " (Attempt " + attempt + "/" + MAX_ATTEMPTS + "): ");
            String pin = scanner.nextLine();

            if (userPins.getOrDefault(id, "9999").equals(pin)) { // ถ้าไม่มีค่าใน userPins จะใช้ "9999"
                failedAttempts.put(id, 0); // รีเซ็ตจำนวนครั้งที่ผิด
                return true;
            } else {
                System.out.println("Incorrect PIN.");
                failedAttempts.put(id, failedAttempts.getOrDefault(id, 0) + 1);
            }

            // ถ้าผิดครบ 3 ครั้ง -> ล็อคบัญชี
            if (failedAttempts.get(id) >= MAX_ATTEMPTS) {
                System.out.println("Too many failed attempts! Your account is now locked.");
                lockedUsers.add(id);
                return false;
            }
        }
        return false;
    }
}
