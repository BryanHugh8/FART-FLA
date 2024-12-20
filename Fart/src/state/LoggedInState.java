package state;

import models.User;

public class LoggedInState implements State {
    @Override
    public void login(User user, String username, String password) {
        System.out.println("Already logged in.");
    }

    @Override
    public void logout(User user) {
        user.setState(new LoggedOutState());
        System.out.println(user.getUsername() + " logged out.");
    }
}