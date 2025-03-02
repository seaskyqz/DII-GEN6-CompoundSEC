public class VIPCard extends CardDecorator {
    public VIPCard(AccessCard card) {
        super(card);
    }

    public String getDetails() {
        return super.getDetails() + " with VIP Access";
    }
}
