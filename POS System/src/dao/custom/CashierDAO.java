package dao.custom;

import dao.CrudDAO;
import entity.Cashier;

import java.sql.SQLException;

public interface CashierDAO extends CrudDAO<Cashier,String> {
    public String generateCashierId();
    public boolean cashierLogin(String email,String password);
    public boolean checkNicAndUserNameIsExists(String name,String nic);
    public boolean ifCashierIdExists(String id);
}
