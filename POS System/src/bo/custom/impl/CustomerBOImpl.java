package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public String generateCustomerId(){
        return customerDAO.generateCustomerId();
    }

    @Override
    public ArrayList<String> getCustomerIds(){
        ArrayList<String> customerIds = customerDAO.getCustomerIds();
        return customerIds;
    }

    @Override
    public boolean addCustomer(CustomerDTO c){
        return customerDAO.add(new Customer(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerNic(), c.getCustomerCity()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO c){
        return customerDAO.update(new Customer(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerNic(), c.getCustomerCity()));
    }

    @Override
    public boolean deleteCustomer(CustomerDTO c) {
        return customerDAO.delete(new Customer(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerNic(), c.getCustomerCity()));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<Customer> getAll = customerDAO.getAll();
        ArrayList<CustomerDTO> getCustomers = new ArrayList<>();
        for (Customer c : getAll
        ) {
            getCustomers.add(new CustomerDTO(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerNic(), c.getCustomerCity()));
        }
        return getCustomers;
    }

    @Override
    public CustomerDTO searchCustomer(String id){
        Customer customer = customerDAO.search(id);
        return new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerNic(), customer.getCustomerCity());
    }

    @Override
    public boolean checkIfNicIsExists(String nic){
        return customerDAO.checkIfNicIsExists(nic);
    }

    @Override
    public boolean ifCustomerExists(String id){
        return customerDAO.ifCustomerExists(id);
    }
}
