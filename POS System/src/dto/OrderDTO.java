package dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class OrderDTO {
    private String orderId;
    private CustomerDTO customer;
    private Date orderDate;
    private String orderTime;
    private BigDecimal cost;
    private ArrayList<ItemDetailsDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(BigDecimal cost) {
        this.cost = cost;
    }

    public OrderDTO(String orderId, CustomerDTO customer, Date orderDate, String orderTime, BigDecimal cost, ArrayList<ItemDetailsDTO> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cost = cost;
        this.items = items;
    }

    public OrderDTO(String orderId, CustomerDTO customer, Date orderDate, String orderTime, BigDecimal cost) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cost = cost;
    }

    public OrderDTO(String orderId, CustomerDTO customer, ArrayList<ItemDetailsDTO> orderDetails) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = orderDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CustomerDTO getCustomerId() {
        return customer;
    }

    public void setCustomerId(CustomerDTO customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public ArrayList<ItemDetailsDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemDetailsDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customer + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", cost=" + cost +
                ", items=" + items +
                '}';
    }
}
