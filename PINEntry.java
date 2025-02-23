import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

class PINEntry {
    private static final int MAX_ATTEMPTS = 3;
    private Map<String, String> studentPINs = new HashMap<>();
    private Map<String, Integer> failedAttempts = new HashMap<>();
    private Set<String> lockedAccounts = new HashSet<>();

    public PINEntry() {
        studentPINs.put("S001", hashPIN("1234"));
        studentPINs.put("S002", hashPIN("5678"));
    }

    private String hashPIN(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean authenticate(String studentID, Scanner scanner) {
        if (lockedAccounts.contains(studentID)) {
            System.out.println("Account is locked due to too many failed attempts.");
            return false;
        }

        int attempts = failedAttempts.getOrDefault(studentID, 0);

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter PIN for " + studentID + ": ");
            String enteredPIN = hashPIN(scanner.nextLine());

            if (studentPINs.get(studentID).equals(enteredPIN)) {
                System.out.println("Access granted.");
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                failedAttempts.put(studentID, attempts);
            }
        }

        lockedAccounts.add(studentID);
        System.out.println("Too many failed attempts. Account locked.");
        return false;
    }
}