public abstract class CardDecorator implements AccessCard {
    protected final AccessCard decoratedCard;

    public CardDecorator(AccessCard decoratedCard) {
        this.decoratedCard = decoratedCard;
    }

    public String getDetails() {
        return decoratedCard.getDetails();
    }
}
