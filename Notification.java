import java.util.Arrays;
import java.util.List;

interface Notification {
    void sendAlert(String personID);
}

class SMSNotification implements Notification {
    public void sendAlert(String personID) {
        System.out.println("SMS sent for " + personID);
    }
}

class EmailNotification implements Notification {
    public void sendAlert(String personID) {
        System.out.println("Email sent for " + personID);
    }
}

class NotificationSystem {
    private static List<Notification> notifications = Arrays.asList(
            new SMSNotification(), new EmailNotification()
    );

    public static void notifyAccessAttempt(String personID) {
        for (Notification n : notifications) {
            n.sendAlert(personID);
        }
    }