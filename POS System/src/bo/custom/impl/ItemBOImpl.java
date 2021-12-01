package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO i){
        return itemDAO.add(new Item(i.getItemCode(), i.getItemDescription(), i.getSize(), i.getQty(), i.getBuyingPrice(), i.getUnitPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO i){
        return itemDAO.update(new Item(i.getItemCode(), i.getItemDescription(), i.getSize(), i.getQty(), i.getBuyingPrice(), i.getUnitPrice()));
    }

    @Override
    public boolean deleteItem(ItemDTO i) {
        return itemDAO.delete(new Item(i.getItemCode(), i.getItemDescription(), i.getSize(), i.getQty(), i.getBuyingPrice(), i.getUnitPrice()));
    }

    @Override
    public ItemDTO searchItem(String s) {
        Item i = itemDAO.search(s);
        return new ItemDTO(i.getItemCode(), i.getItemDescription(), i.getSize(), i.getQty(), i.getBuyingPrice(), i.getUnitPrice());
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        ArrayList<Item> items = itemDAO.getAll();
        ArrayList<ItemDTO> itemDTOAll = new ArrayList<>();
        for (Item i : items
        ) {
            itemDTOAll.add(new ItemDTO(i.getItemCode(), i.getItemDescription(), i.getSize(), i.getQty(), i.getBuyingPrice(), i.getUnitPrice()));
        }
        return itemDTOAll;
    }

    @Override
    public ArrayList<String> getItemCodes(){
        return itemDAO.getItemCodes();
    }

    @Override
    public String generateItemCode(){
        return itemDAO.generateItemCode();
    }

    @Override
    public boolean ifItemExists(String itemCode){
        return itemDAO.ifItemExists(itemCode);
    }

    @Override
    public ArrayList<ItemDTO> itemsLessThanFive(){
        ArrayList<Item> items = itemDAO.itemsLessThanFive();
        ArrayList<ItemDTO>itemDTOS=new ArrayList<>();
        for (Item i:items
             ) {
            itemDTOS.add(new ItemDTO(i.getItemCode(),i.getItemDescription(),i.getSize(),i.getQty(),i.getBuyingPrice(),i.getUnitPrice()));
        }return itemDTOS;
    }
}
