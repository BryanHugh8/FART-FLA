package models;

import state.State;
import state.LoggedOutState;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Artwork> boughtItems = new ArrayList<>();
    private State state;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.state = new LoggedOutState();
    }

    public void login(String username, String password) {
        state.login(this, username, password);
    }

    public void logout() {
        state.logout(this);
    }

    public void addBoughtItem(Artwork artwork) {
        boughtItems.add(artwork);
    }

    public List<Artwork> getBoughtItems() {
        return boughtItems;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setState(State state) {
        this.state = state;
    }
}
