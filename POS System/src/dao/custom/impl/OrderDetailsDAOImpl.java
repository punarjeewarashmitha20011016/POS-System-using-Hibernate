package dao.custom.impl;

import dao.custom.OrderDetailsDAO;
import entity.OrderDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean add(OrderDetails orderDetails) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(orderDetails);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(OrderDetails orderDetails) {
        throw new UnsupportedOperationException("Not supported Yet");
    }

    @Override
    public boolean delete(OrderDetails s) {
        throw new UnsupportedOperationException("Not supported Yet");
    }

    @Override
    public ArrayList<OrderDetails> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM OrderDetails";
        Query query = session.createQuery(hql);
        List<OrderDetails> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<OrderDetails>) list;
    }

    @Override
    public OrderDetails search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        OrderDetails orderDetails = session.get(OrderDetails.class, s);
        transaction.commit();
        session.close();
        return orderDetails;
    }
}
