package pl.academy.code.services;

import pl.academy.code.model.User;

public interface UserService {
    void saveUser(User user);
    User getUserById(int id);
    boolean authorizeUser(User user);
}
