package bo.custom.impl;

import bo.custom.MakeAnOrderBO;
import dao.DAOFactory;
import dao.custom.*;
import dto.*;
import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MakeAnOrderBOImpl implements MakeAnOrderBO {
    private OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDER);
    private OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.OrderDetails);
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);
    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);
    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.Query);

    @Override
    public boolean purchaseOrder(OrderDTO dto,ItemDTO itemDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        if (orderDAO.orderExists(dto.getOrderId())) {
            return false;
        }
        Customer customer = customerDAO.search(dto.getCustomerId().getCustomerId());
        Order order = new Order(dto.getOrderId(), customer, dto.getOrderDate(), dto.getOrderTime(), dto.getCost());
        if (!orderDAO.add(order)) {
            return false;
        }
        for (ItemDetailsDTO itemDetailsDTO : dto.getItems()
        ) {
            ItemDetails itemDetails = new ItemDetails(itemDetailsDTO.getItemCode(), itemDetailsDTO.getItemQtyOnHand(), itemDetailsDTO.getUnitPrice(), itemDetailsDTO.getDiscountPrice());
            OrderDetails orderDetails = new OrderDetails(new Item(itemDTO.getItemCode(),itemDTO.getItemDescription(),itemDTO.getSize(),itemDTO.getQty(),itemDTO.getBuyingPrice(),itemDTO.getUnitPrice()), new Order(dto.getOrderId(),customer,dto.getOrderDate(),dto.getOrderTime(),dto.getCost()), itemDetails.getItemQtyOnHand(), itemDetails.getDiscountPrice(), itemDetails.getUnitPrice());
            boolean add = orderDetailsDAO.add(orderDetails);
            if (!add) {
                return false;
            }
            Item search = itemDAO.search(itemDetails.getItemCode());
            search.setQty(search.getQty() - itemDetails.getItemQtyOnHand());
            boolean update = itemDAO.update(search);
            if (!update) {
                return false;
            }
        }
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public String generateOrderId() {
        return orderDAO.generateOrderId();
    }

    @Override
    public ArrayList<String> getCustomerIds() {
        return customerDAO.getCustomerIds();
    }

    @Override
    public ArrayList<String> getItemCodes() {
        return itemDAO.getItemCodes();
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Customer search = customerDAO.search(id);
        return new CustomerDTO(search.getCustomerId(), search.getCustomerName(), search.getCustomerAddress(), search.getCustomerNic(), search.getCustomerCity());
    }

    @Override
    public ItemDTO searchItem(String code) {
        Item search = itemDAO.search(code);
        return new ItemDTO(search.getItemCode(), search.getItemDescription(), search.getSize(), search.getQty(), search.getBuyingPrice(), search.getUnitPrice());
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails() {
        ArrayList<OrderDetails> all = orderDetailsDAO.getAll();
        ArrayList<OrderDetailsDTO> allOrderDetails = new ArrayList<>();
        for (OrderDetails details : all
        ) {
            allOrderDetails.add(new OrderDetailsDTO(details.getItemCode().getItemCode(), details.getOrderId().getOrderId(), details.getOrderQty(), details.getDiscount(), details.getPrice()));
        }
        return allOrderDetails;
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() {
        ArrayList<Order> all = orderDAO.getAll();
        ArrayList<OrderDTO> allOrders = new ArrayList<>();
        for (Order details : all
        ) {
            allOrders.add(new OrderDTO(details.getOrderId(), new CustomerDTO(details.getCustomer().getCustomerId(),details.getCustomer().getCustomerName(),details.getCustomer().getCustomerAddress(),details.getCustomer().getCustomerNic(),details.getCustomer().getCustomerCity()), details.getOrderDate(), details.getOrderTime(), details.getCost()));
        }
        return allOrders;
    }

    @Override
    public ArrayList<OrderDetailsDTO> searchOrderDetails(String orderId) {
        List<CustomDTO> customDTOS = queryDAO.searchOrderDetailsByOrderId(orderId);
        ArrayList<OrderDetailsDTO> orderDetailsDTO = new ArrayList<>();
        for (CustomDTO dto : customDTOS
        ) {
            orderDetailsDTO.add(new OrderDetailsDTO(dto.getItemCode(), dto.getOrderId(), dto.getOrderQty(), dto.getDiscount(), dto.getPrice()));
        }
        return orderDetailsDTO;
    }

    @Override
    public OrderDTO searchOrder(String orderId) {
        Order search = orderDAO.search(orderId);
        return new OrderDTO(search.getOrderId(), new CustomerDTO(search.getCustomer().getCustomerId(),search.getCustomer().getCustomerName(),search.getCustomer().getCustomerAddress(),search.getCustomer().getCustomerNic(),search.getCustomer().getCustomerCity()), search.getOrderDate(), search.getOrderTime(), search.getCost());
    }

    @Override
    public boolean orderExists(String orderId) {
        return orderDAO.orderExists(orderId);
    }
}
