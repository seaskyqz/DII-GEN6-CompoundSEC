import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PINEntry pinEntry = new PINEntry();
        CardManager.initialize(); // เตรียมข้อมูล Access Card

        Set<String> availableRooms = Set.of("Library", "Cafeteria", "Classroom", "Office", "Meeting Room", "Storage Room");

        while (true) {
            System.out.println("\nSelect user type: (1) Student, (2) Director, (3) Teacher, (4) Janitor, (q) Quit");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                System.out.println("Exiting program...");
                break;
            }

            Person user = switch (choice) {
                case "1" -> new Student("S001", "Alice");
                case "2" -> new Director("D001", "Mr. Smith");
                case "3" -> new Teacher("T001", "Ms. Brown");
                case "4" -> new Janitor("J001", "Mr. John");
                default -> null;
            };

            if (user == null) {
                System.out.println("Invalid selection. Try again.");
                continue;
            }

            if (!pinEntry.authenticate(user.getID())) {
                continue;
            }

            System.out.print("Enter floor (LOW, MEDIUM, HIGH): ");
            Floor floor;
            try {
                floor = Floor.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid floor input. Try again.");
                continue;
            }

            System.out.println("Available rooms: " + availableRooms);
            System.out.print("Enter room to access: ");
            String room = scanner.nextLine();

            if (AccessControl.hasAccess(user, floor, room)) {
                System.out.println("Access granted to " + room + " on " + floor + " floor.");
                AuditTrail.getInstance().log(user.getID() + " accessed " + room + " on " + floor + " floor.");
            } else {
                System.out.println("Access denied to " + room + " on " + floor + " floor.");
                AuditTrail.getInstance().log(user.getID() + " was denied access to " + room + " on " + floor + " floor.");
            }

            if (user instanceof Director) {
                while (true) {
                    System.out.println("\nCard Management Options:");
                    System.out.println("1. Add new card");
                    System.out.println("2. Modify existing card");
                    System.out.println("3. Revoke a card");
                    System.out.println("4. Exit card management");
                    System.out.print("Select an option: ");

                    String option = scanner.nextLine();
                    if (option.equals("4")) break;

                    switch (option) {
                        case "1" -> {
                            System.out.print("Enter new card ID: ");
                            String newId = scanner.nextLine();
                            System.out.print("Enter owner name: ");
                            String owner = scanner.nextLine();
                            CardManager.addCard(newId, new BasicCard(owner));
                        }
                        case "2" -> {
                            System.out.print("Enter card ID to modify: ");
                            String modId = scanner.nextLine();
                            System.out.print("Enter new owner name: ");
                            String newOwner = scanner.nextLine();
                            CardManager.modifyCard(modId, new VIPCard(new BasicCard(newOwner)));
                        }
                        case "3" -> {
                            System.out.print("Enter card ID to revoke: ");
                            String revId = scanner.nextLine();
                            CardManager.revokeCard(revId);
                        }
                        default -> System.out.println("Invalid option. Try again.");
                    }
                }
            }
        }
    }
}
