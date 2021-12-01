package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public boolean addItem(ItemDTO i);
    public boolean updateItem(ItemDTO i);
    public boolean deleteItem(ItemDTO s);
    public ItemDTO searchItem(String s);
    public ArrayList<ItemDTO>getAllItems();
    public ArrayList<String>getItemCodes();
    public String generateItemCode();
    public boolean ifItemExists(String itemCode);
    public ArrayList<ItemDTO> itemsLessThanFive();
}
