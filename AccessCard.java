interface AccessCard {
    String getDetails();
}

class BasicCard implements AccessCard {
    private String owner;
    public BasicCard(String owner) { this.owner = owner; }
    @Override
    public String getDetails() { return "Basic Card for " + owner; }
}

abstract class CardDecorator implements AccessCard {
    protected AccessCard decoratedCard;
    public CardDecorator(AccessCard decoratedCard) {
        this.decoratedCard = decoratedCard;
    }
    @Override
    public String getDetails() { return decoratedCard.getDetails(); }
}

class TimeBasedEncryptionCard extends CardDecorator {
    public TimeBasedEncryptionCard(AccessCard decoratedCard) { super(decoratedCard); }
    @Override
    public String getDetails() { return super.getDetails() + " with Time-Based Encryption"; }
}

class VIPCard extends CardDecorator {
    public VIPCard(AccessCard decoratedCard) { super(decoratedCard); }
    @Override
    public String getDetails() { return super.getDetails() + " with VIP Access"; }
}