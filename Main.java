public class Main {
    public static void main(String[] args) {
        // ======= ทดสอบระบบข้อมูลนักเรียน (ดราฟที่ 1) =======
        System.out.println("=== Student Information System ===");
        StudentInfo student1 = new RegularStudent("S001", "Alice", "Grade 10");
        StudentInfo student2 = new SpecialStudent("S002", "Bob", "Grade 11", "Scholarship");

        student1.displayInfo();
        student2.displayInfo();

        // ======= ทดสอบระบบแจ้งเตือน (ดราฟที่ 2) =======
        System.out.println("\n=== Notification System ===");
        Notification sms = new SMSNotification();
        Notification email = new EmailNotification();
        Notification app = new AppNotification();

        // ส่งการแจ้งเตือนให้นักเรียน
        sms.send("Alice has entered the school.");
        email.send("Bob has left the school.");
        app.send("Emergency Alert: School lockdown.");

        // ======= ทดสอบระบบเข้า-ออกโรงเรียน (ดราฟที่ 3) =======
        System.out.println("\n=== Entry/Exit System ===");
        SchoolEntryExit rfidEntry = new StudentEntryExit(new RFID());
        SchoolEntryExit qrCodeEntry = new StudentEntryExit(new QRCode());
        SchoolEntryExit appEntry = new StudentEntryExit(new MobileApp());

        rfidEntry.performEntryExit();
        qrCodeEntry.performEntryExit();
        appEntry.performEntryExit();
    }
}