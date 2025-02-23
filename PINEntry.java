import java.util.*;

class PINEntry {
    private static final int MAX_ATTEMPTS = 3;
    private Map<String, String> personPINs = new HashMap<>();
    private Map<String, Integer> failedAttempts = new HashMap<>();
    private Set<String> lockedAccounts = new HashSet<>();

    public PINEntry() {
        personPINs.put("D001", "9999"); // Director
        personPINs.put("T001", "1234"); // Teacher
        personPINs.put("J001", "5678"); // Janitor
        personPINs.put("S001", "0000"); // Student
    }

    public boolean authenticate(String personID) {
        if (lockedAccounts.contains(personID)) {
            System.out.println("Account is locked due to too many failed attempts.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        int attempts = failedAttempts.getOrDefault(personID, 0);

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter PIN for " + personID + ": ");
            String enteredPIN = scanner.nextLine();

            if (personPINs.get(personID).equals(enteredPIN)) {
                System.out.println("Access granted.");
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                failedAttempts.put(personID, attempts);
            }
        }

        lockedAccounts.add(personID);
        System.out.println("Too many failed attempts. Account locked.");
        return false;
    }
}