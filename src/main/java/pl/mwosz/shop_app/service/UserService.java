package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();
    boolean saveUser(User user);
}
