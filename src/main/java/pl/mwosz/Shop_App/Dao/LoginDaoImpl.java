package pl.mwosz.Shop_App.Dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class LoginDaoImpl implements LoginDao {

    private Connection connection;
    private static final String DB_CLIENT = "jdbc:h2:file:~/shop-application/db/clients";
    private static final String DB_LOGIN = "sa";
    private static final String DB_PASSWORD = "";
    private static final String LOGIN_QUERY = "SELECT * FROM CLIENT WHERE LOGIN = ? AND PASSWORD = ?";

    @Override
    public boolean loginResult(String login, String password) {
        return false;
    }
}
