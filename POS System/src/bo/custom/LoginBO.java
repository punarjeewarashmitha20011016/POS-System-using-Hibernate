package bo.custom;

import bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    public boolean login(String userName,String password) throws SQLException;
}
