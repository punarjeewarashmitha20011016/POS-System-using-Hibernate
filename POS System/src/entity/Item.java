package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Item {
    @Id
    private String itemCode;
    private String itemDescription;
    private double size;
    private int qty;
    private double buyingPrice;
    private double unitPrice;
    @OneToMany
    private List<OrderDetails> items;


    public Item() {
    }

    public Item(String itemCode, String itemDescription, double size, int qty, double buyingPrice, double unitPrice, List<OrderDetails> order) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.size = size;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        this.items = order;
    }

    public Item(String itemCode, String itemDescription, double size, int qty, double buyingPrice, double unitPrice) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.size = size;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<OrderDetails> getOrder() {
        return items;
    }

    public void setOrder(List<OrderDetails> order) {
        this.items = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", size=" + size +
                ", qty=" + qty +
                ", buyingPrice=" + buyingPrice +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
