package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;

import java.util.ArrayList;

public interface ViewItemsBO extends SuperBO {
    public ArrayList<ItemDTO> getAllItems();
}
