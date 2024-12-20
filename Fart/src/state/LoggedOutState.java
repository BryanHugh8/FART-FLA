package state;

import models.User;

public class LoggedOutState implements State {
    @Override
    public void login(User user, String username, String password) {
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            user.setState(new LoggedInState());
            System.out.println(user.getUsername() + " logged in.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    @Override
    public void logout(User user) {
        System.out.println("Already logged out.");
    }
}
