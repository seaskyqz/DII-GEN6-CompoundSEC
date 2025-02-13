public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Notification System ===");

        StudentNotifier smsNotifier = new StudentNotifier(new SMSNotification());
        StudentNotifier emailNotifier = new StudentNotifier(new EmailNotification());
        StudentNotifier appNotifier = new StudentNotifier(new AppNotification());

        smsNotifier.notifyStudent("Alice's schedule has been updated.");
        emailNotifier.notifyStudent("Bob's exam results are available.");
        appNotifier.notifyStudent("School event: Sports day tomorrow.");

        System.out.println("\n=== Student Information ===");

        Student student1 = new RegularStudent("S001", "Alice", "Grade 10");
        Student student2 = new SpecialStudent("S002", "Bob", "Grade 11", "Scholarship");

        student1.displayInfo();
        student2.displayInfo();

        System.out.println("\n=== Entry/Exit System ===");
        SchoolEntryExit rfidEntry = new StudentEntryExit(new RFID());
        SchoolEntryExit qrCodeEntry = new StudentEntryExit(new QRCode());
        SchoolEntryExit appEntry = new StudentEntryExit(new MobileApp());

        rfidEntry.performEntryExit();
        qrCodeEntry.performEntryExit();
        appEntry.performEntryExit();
    }
}
