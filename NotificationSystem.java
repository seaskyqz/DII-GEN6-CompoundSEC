// Interface สำหรับระบบแจ้งเตือน
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