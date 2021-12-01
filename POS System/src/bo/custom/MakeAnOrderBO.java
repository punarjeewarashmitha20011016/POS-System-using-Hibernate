package bo.custom;

import bo.SuperBO;
import dto.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface MakeAnOrderBO extends SuperBO {
    public boolean purchaseOrder(OrderDTO dto,ItemDTO itemDTO);
    public String generateOrderId();
    public ArrayList<String>getCustomerIds();
    public ArrayList<String>getItemCodes() ;
    public CustomerDTO searchCustomer(String id);
    public ItemDTO searchItem(String code);
    public ArrayList<OrderDetailsDTO>getAllOrderDetails();
    public ArrayList<OrderDTO>getAllOrders();
    public ArrayList<OrderDetailsDTO>searchOrderDetails(String orderId);
    public OrderDTO searchOrder(String orderId);
    public boolean orderExists(String orderId);
}
