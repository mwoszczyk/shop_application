package pl.mwosz.shop_app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.shop_app.dao.LoginDao;
import pl.mwosz.shop_app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public boolean logIn(String login, String password) {

        return loginDao.loginResult(login,password);
    }
}
