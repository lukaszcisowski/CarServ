package pl.coderslab.carserv.service;

import pl.coderslab.carserv.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
