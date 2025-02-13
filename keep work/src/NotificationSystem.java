interface Notification {
    void send(String message);
}

// แจ้งเตือนผ่าน SMS
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// แจ้งเตือนผ่าน Email
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// แจ้งเตือนผ่านแอปพลิเคชัน
class AppNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending App Notification: " + message);
    }
}

// ระบบแจ้งเตือนนักเรียน
class StudentNotifier {
    private Notification notification;

    public StudentNotifier(Notification notification) {
        this.notification = notification;
    }

    public void notifyStudent(String message) {
        notification.send(message);
    }
}

// ทดสอบการทำงานของ Polymorphism ในระบบแจ้งเตือน
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Notification System ===");

        StudentNotifier smsNotifier = new StudentNotifier(new SMSNotification());
        StudentNotifier emailNotifier = new StudentNotifier(new EmailNotification());
        StudentNotifier appNotifier = new StudentNotifier(new AppNotification());

        smsNotifier.notifyStudent("Alice's schedule has been updated.");
        emailNotifier.notifyStudent("Bob's exam results are available.");
        appNotifier.notifyStudent("School event: Sports day tomorrow.");
    }
}
