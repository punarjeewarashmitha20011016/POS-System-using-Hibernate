package dao.custom.impl;

import dao.custom.QueryDAO;
import dto.CustomDTO;
import dto.CustomerDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomDTO> searchOrderDetailsByOrderId(String orderId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select o.orderId,od.orderQty,od.discount,od.price,od.itemCode from Order o inner join OrderDetails od on od.orderId=o.orderId where o.orderId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", orderId);
        List<CustomDTO> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<CustomDTO>) list;
    }


}
