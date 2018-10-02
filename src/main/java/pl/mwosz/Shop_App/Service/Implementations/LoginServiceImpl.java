package pl.mwosz.Shop_App.Service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.LoginDao;
import pl.mwosz.Shop_App.Service.LoginService;

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
