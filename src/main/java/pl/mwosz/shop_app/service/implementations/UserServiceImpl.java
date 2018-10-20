package pl.mwosz.shop_app.service.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.shop_app.dao.UserDao;
import pl.mwosz.shop_app.domain.User;
import pl.mwosz.shop_app.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public boolean saveUser(User user) {
        userDao.save(user);
        return null != user.getId();
    }
}
