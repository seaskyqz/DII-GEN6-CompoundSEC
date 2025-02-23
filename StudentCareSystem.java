import java.util.Scanner;

public class StudentCareSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new RegularStudent("S001", "Alice", "Grade 10");
        Student student2 = new SpecialStudent("S002", "Bob", "Grade 11");

        AccessControl accessControl = new AccessControl();
        PINEntry pinEntry = new PINEntry();
        NotificationSystem notificationSystem = new NotificationSystem();
        Admin admin = new Admin(accessControl);

        if (accessControl.validateAccess(student1.getID())) {
            if (pinEntry.authenticate(student1.getID(), scanner)) {
                notificationSystem.notifyParent(student1.getID());
            }
        } else {
            System.out.println("Access denied for " + student1.getID());
        }

        scanner.close();
    }
}