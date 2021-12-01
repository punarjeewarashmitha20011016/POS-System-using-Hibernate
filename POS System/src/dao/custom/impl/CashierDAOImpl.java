package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CashierDAO;
import entity.Cashier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public boolean add(Cashier cashier) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(cashier);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Cashier cashier) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(cashier);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Cashier cashier) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cashier);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Cashier> getAll(){
        return null;
    }

    @Override
    public Cashier search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Cashier cashier = session.get(Cashier.class, s);
        transaction.commit();
        session.close();
        return cashier;
    }

    @Override
    public String generateCashierId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT id FROM Cashier order by id desc limit 1";
        NativeQuery query = session.createSQLQuery(sql);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        for (String ids : list
        ) {
            int temp = Integer.parseInt(ids.split("-")[1]);
            temp = temp + 1;
            if (temp <= 9) {
                return "CA-00" + temp;
            } else if (temp <= 99) {
                return "CA-0" + temp;
            } else {
                return "CA-" + temp;
            }
        }
        return "CA-001";
    }

    @Override
    public boolean cashierLogin(String name, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Cashier WHERE name=:userName AND password=:pass";
        Query query = session.createQuery(hql);
        query.setParameter("userName", name);
        query.setParameter("pass", password);
        List<Cashier> list = query.list();
        transaction.commit();
        session.close();
       if (list!=null){
           return true;
       }return false;
    }

    @Override
    public boolean checkNicAndUserNameIsExists(String name, String nic){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT name,nic from Cashier where nic=:nicNo or name=:Name";
        Query query = session.createQuery(hql);
        query.setParameter("nicNo", nic);
        query.setParameter("Name", name);
        List<Cashier> list = query.list();
        transaction.commit();
        session.close();
        if (list!=null){
            return true;
        }return false;
    }

    @Override
    public boolean ifCashierIdExists(String id){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Cashier WHERE id=:ids";
        Query query = session.createQuery(hql);
        query.setParameter("ids", id);
        List<Cashier> list = query.list();
        transaction.commit();
        session.close();
        if (list!=null){
            return true;
        }return false;
    }
}
