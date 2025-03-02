public class BasicCard implements AccessCard {
    private final String owner;

    public BasicCard(String owner) {
        this.owner = owner;
    }

    public String getDetails() {
        return "Basic Card for " + owner;
    }
}
