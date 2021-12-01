package bo.custom.impl;

import bo.custom.CashierBO;
import dao.DAOFactory;
import dao.custom.CashierDAO;
import entity.Cashier;
import dto.CashierDTO;

import java.sql.SQLException;

public class CashierBOImpl implements CashierBO {
    private CashierDAO cashierDAO = (CashierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CASHIER);

    @Override
    public boolean addCashier(CashierDTO c){
        return cashierDAO.add(new Cashier(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getPassword()));
    }

    @Override
    public boolean updateCashier(CashierDTO c){
        return cashierDAO.update(new Cashier(c.getId(),c.getName(), c.getNic(), c.getEmail(), c.getPassword()));
    }

    @Override
    public boolean deleteCashier(CashierDTO c){
        return cashierDAO.delete(new Cashier(c.getId(),c.getName(), c.getNic(), c.getEmail(), c.getPassword()));
    }

    @Override
    public String generateCashierId(){
        return cashierDAO.generateCashierId();
    }
    @Override
    public boolean checkNicAndUserNameIsExists(String name, String nic){
        return cashierDAO.checkNicAndUserNameIsExists(name,nic);
    }

    @Override
    public CashierDTO searchCashier(String cashierId){
        Cashier search = cashierDAO.search(cashierId);
        return new CashierDTO(search.getId(),search.getName(),search.getNic(),search.getEmail(),search.getPassword());
    }

    @Override
    public boolean ifCashierIdExists(String id){
       return cashierDAO.ifCashierIdExists(id);
    }
}
