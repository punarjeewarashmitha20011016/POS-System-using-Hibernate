package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public String generateCustomerId();

    public ArrayList<String> getCustomerIds();

    public boolean addCustomer(CustomerDTO c);

    public boolean updateCustomer(CustomerDTO c);

    public boolean deleteCustomer(CustomerDTO s);

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO searchCustomer(String id);

    public boolean checkIfNicIsExists(String nic);

    public boolean ifCustomerExists(String id);
}
