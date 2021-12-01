package dao.custom;

import dao.CrudDAO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    public String generateItemCode();
    public ArrayList<String>getItemCodes();
    public boolean ifItemExists(String itemCode);
    public ArrayList<Item> itemsLessThanFive();
}
