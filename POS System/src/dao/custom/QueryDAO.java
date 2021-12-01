package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<CustomDTO> searchOrderDetailsByOrderId(String orderId);
}
