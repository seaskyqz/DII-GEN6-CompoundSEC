import java.util.Arrays;
import java.util.List;

interface Notification {
    void sendAlert(String studentID);
}

class SMSNotification implements Notification {
    public void sendAlert(String studentID) {
        System.out.println("SMS sent to parent of " + studentID);
    }
}

class EmailNotification implements Notification {
    public void sendAlert(String studentID) {
        System.out.println("Email sent to parent of " + studentID);
    }
}

class AppNotification implements Notification {
    public void sendAlert(String studentID) {
        System.out.println("App notification sent for " + studentID);
    }
}

class NotificationSystem {
    private List<Notification> notifications;

    public NotificationSystem() {
        this.notifications = Arrays.asList(
                new SMSNotification(), new EmailNotification(), new AppNotification()
        );
    }

    public void notifyParent(String studentID) {
        for (Notification n : notifications) {
            n.sendAlert(studentID);
        }
    }
}