import java.util.HashMap;
import java.util.Map;

public class CardManager {
    private static final Map<String, AccessCard> cards = new HashMap<>();

    public static void initialize() {
        addCard("S001", new BasicCard("Alice"));
        addCard("T001", new TimeBasedEncryptionCard(new BasicCard("Ms. Brown")));
        addCard("D001", new VIPCard(new BasicCard("Mr. Smith")));
        addCard("J001", new BasicCard("Mr. John"));
    }

    public static void addCard(String id, AccessCard card) {
        cards.put(id, card);
        AuditTrail.getInstance().log("New card created for " + id + ": " + card.getDetails());
    }

    public static void modifyCard(String id, AccessCard newCard) {
        cards.put(id, newCard);
        AuditTrail.getInstance().log("Card for " + id + " modified: " + newCard.getDetails());
    }

    public static void revokeCard(String id) {
        cards.remove(id);
        AuditTrail.getInstance().log("Card for " + id + " revoked");
    }

    public static AccessCard getCard(String id) {
        return cards.get(id);
    }
}
