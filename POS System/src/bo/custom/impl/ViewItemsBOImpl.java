package bo.custom.impl;

import bo.custom.ViewItemsBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.util.ArrayList;

public class ViewItemsBOImpl implements ViewItemsBO {
    ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);
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
}
