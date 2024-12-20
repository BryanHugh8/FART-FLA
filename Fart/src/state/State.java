package state;

import models.User;

public interface State {
    void login(User user, String username, String password);
    void logout(User user);
}
