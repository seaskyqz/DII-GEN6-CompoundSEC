import java.util.Scanner;

public class StudentCareSystem {
    public static void main(String[] args) {
        PINEntry pinEntry = new PINEntry();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select user type: (1) Student, (2) Director, (3) Teacher, (4) Janitor");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Person user = null;
        if (choice == 1) user = new Student("S001", "Alice");
        else if (choice == 2) user = new Director("D001", "Mr. Smith");
        else if (choice == 3) user = new Teacher("T001", "Ms. Brown");
        else if (choice == 4) user = new Janitor("J001", "Mr. John");

        if (user != null && pinEntry.authenticate(user.getID())) {
            System.out.print("Enter area to access: ");
            String area = scanner.nextLine();
            if (user.hasAccess(area)) {
                System.out.println("Access to " + area + " granted.");
                NotificationSystem.notifyAccessAttempt(user.getID());
            } else {
                System.out.println("Access denied to " + area);
            }
        }
    }
}