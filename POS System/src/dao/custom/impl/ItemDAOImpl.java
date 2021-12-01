package dao.custom.impl;

import dao.custom.ItemDAO;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item item) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Item item) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Item> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Item";
        Query query = session.createQuery(hql);
        List<Item> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Item>) list;
    }

    @Override
    public Item search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.load(Item.class, s);
        transaction.commit();
        session.close();
        return item;
    }

    @Override
    public String generateItemCode() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT itemCode from Item order by itemCode desc limit 1";
        NativeQuery query = session.createSQLQuery(sql);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        for (String code : list) {
            int temp = Integer.parseInt(code.split("-")[1]);
            temp = temp + 1;
            if (temp <= 9) {
                return "I-00" + temp;
            } else if (temp <= 99) {
                return "I-0" + temp;
            } else {
                return "I-" + temp;
            }
        }
        return "I-001";
    }

    @Override
    public ArrayList<String> getItemCodes() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT itemCode from Item";
        Query query = session.createQuery(hql);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<String>) list;
    }

    @Override
    public boolean ifItemExists(String itemCode) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class, itemCode);
        transaction.commit();
        session.close();
        return item != null ? true : false;
    }

    @Override
    public ArrayList<Item> itemsLessThanFive() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT * FROM Item where qty <=5";
        NativeQuery query = session.createSQLQuery(sql);
        query.addEntity(Item.class);
        List<Item> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Item>) list;
    }
}
