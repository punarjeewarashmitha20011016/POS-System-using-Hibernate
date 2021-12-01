package dao.custom;

import dao.CrudDAO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public String generateCustomerId();
    public ArrayList<String>getCustomerIds();
    public boolean checkIfNicIsExists(String nic);
    public boolean ifCustomerExists(String id);
}
