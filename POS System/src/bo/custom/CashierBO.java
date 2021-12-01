package bo.custom;

import bo.SuperBO;
import dto.CashierDTO;

import java.sql.SQLException;

public interface CashierBO extends SuperBO {
    public boolean addCashier(CashierDTO c);

    public boolean updateCashier(CashierDTO c);

    public boolean deleteCashier(CashierDTO s);

    public String generateCashierId();
    public boolean checkNicAndUserNameIsExists(String name,String nic);

    public CashierDTO searchCashier(String cashierId);

    public boolean ifCashierIdExists(String id);
}
