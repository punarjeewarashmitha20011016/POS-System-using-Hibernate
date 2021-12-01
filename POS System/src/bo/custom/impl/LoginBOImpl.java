package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.CashierDAO;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {

    private CashierDAO cashierDAO= (CashierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CASHIER);
    @Override
    public boolean login(String userName, String password) throws SQLException {
        return cashierDAO.cashierLogin(userName,password);
    }
}
