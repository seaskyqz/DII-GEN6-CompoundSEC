interface Notification {
    void send(String message);
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class AppNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending App Notification: " + message);
    }
}

class StudentNotifier {
    private Notification notification;

    public StudentNotifier(Notification notification) {
        this.notification = notification;
    }

    public void notifyStudent(String message) {
        notification.send(message);
    }
}