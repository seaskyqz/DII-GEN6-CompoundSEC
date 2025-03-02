import java.time.LocalTime;

public class TimeBasedEncryptionCard extends CardDecorator {
    public TimeBasedEncryptionCard(AccessCard card) {
        super(card);
    }

    public String getDetails() {
        if (isWithinValidTime()) {
            return super.getDetails() + " with Time-based Encryption";
        } else {
            return super.getDetails() + " [Access Denied: Outside valid time window]";
        }
    }

    private boolean isWithinValidTime() {
        LocalTime now = LocalTime.now();
        return now.isAfter(LocalTime.of(8, 0)) && now.isBefore(LocalTime.of(18, 0));
    }
}
