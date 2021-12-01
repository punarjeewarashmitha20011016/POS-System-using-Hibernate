package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

import java.util.ArrayList;

public interface ViewCustomersBO extends SuperBO {
    public ArrayList<CustomerDTO> getAllCustomers();
}
