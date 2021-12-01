package dao.custom.impl;

import dao.custom.OrderDAO;
import entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean add(Order order) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Order order) {
        throw new UnsupportedOperationException("Not supported Yet");
    }

    @Override
    public boolean delete(Order s) {
        throw new UnsupportedOperationException("Not supported Yet");
    }

    @Override
    public ArrayList<Order> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Order";
        Query query = session.createQuery(hql);
        List<Order> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Order>) list;
    }

    @Override
    public Order search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, s);
        transaction.commit();
        session.close();
        return order;
    }

    @Override
    public String generateOrderId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT orderId from 'Order' order by orderId desc limit 1";
        System.out.println("hql");
        NativeQuery query = session.createSQLQuery(sql);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        for (String id : list) {
            int temp = Integer.parseInt(id.split("-")[1]);
            temp = temp + 1;
            if (temp <= 9) {
                return "O-00" + temp;
            } else if (temp <= 99) {
                return "O-0" + temp;
            } else {
                return "O-" + temp;
            }
        }
        return "O-001";

    }

    @Override
    public boolean orderExists(String orderId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, orderId);
        transaction.commit();
        session.close();
        return order == null ? false : true;
    }
}
