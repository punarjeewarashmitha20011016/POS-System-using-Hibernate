package bo.custom.impl;

import bo.custom.ViewCustomersBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.util.ArrayList;

public class ViewCustomersBOImpl implements ViewCustomersBO {
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);

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
}
