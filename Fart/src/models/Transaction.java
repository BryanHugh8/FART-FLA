package models;

public class Transaction {
    private User user;
    private Artwork artwork;

    public Transaction(User user, Artwork artwork) {
        this.user = user;
        this.artwork = artwork;
    }

    @Override
    public String toString() {
        return "Transaction{user=" + user.getUsername() + ", artwork=" + artwork.getName() + "}";
    }
}
