package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class OrderDetails {
    @ManyToOne(cascade = CascadeType.ALL)
    private Item itemCode;
    @ManyToOne(cascade = CascadeType.ALL)
    private Order orderId;
    private int orderQty;
    private BigDecimal discount;
    private BigDecimal price;
    @Id
    private String orderDetailsId;

    public OrderDetails() {
    }

    public OrderDetails(Item itemCode, Order orderId, int orderQty, BigDecimal discount, BigDecimal price, String orderDetailsId) {
        this.itemCode = itemCode;
        this.orderId = orderId;
        this.orderQty = orderQty;
        this.discount = discount;
        this.price = price;
        this.orderDetailsId = orderDetailsId;
    }

    public OrderDetails(Item itemCode, Order orderId, int itemQtyOnHand, BigDecimal discountPrice, BigDecimal unitPrice) {
        this.itemCode = itemCode;
        this.orderId = orderId;
        this.orderQty = orderQty;
        this.discount = discount;
        this.price = price;
    }

    public Item getItemCode() {
        return itemCode;
    }

    public void setItemCode(Item itemCode) {
        this.itemCode = itemCode;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(String orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "itemCode=" + itemCode +
                ", orderId=" + orderId +
                ", orderQty=" + orderQty +
                ", discount=" + discount +
                ", price=" + price +
                ", orderDetailsId='" + orderDetailsId + '\'' +
                '}';
    }
}
