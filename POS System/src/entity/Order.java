package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    private String orderId;
    @ManyToOne
    private Customer customer;
    private Date orderDate;
    private String orderTime;
    private BigDecimal cost;
    @OneToMany(mappedBy = "orderId",fetch = FetchType.EAGER)
    private List<OrderDetails> items=new ArrayList<>();

    public Order() {
    }

    public Order(String orderId, Customer customer, Date orderDate, String orderTime, BigDecimal cost, List<OrderDetails> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cost = cost;
        this.items = items;
    }

    public Order(String orderId, Customer customer, Date orderDate, String orderTime, BigDecimal cost) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cost = cost;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public List<OrderDetails> getItems() {
        return items;
    }

    public void setItems(List<OrderDetails> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", orderTime='" + orderTime + '\'' +
                ", cost=" + cost +
                '}';
    }
}
