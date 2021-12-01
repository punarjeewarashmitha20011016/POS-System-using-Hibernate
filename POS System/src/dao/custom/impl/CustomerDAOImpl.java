package dao.custom.impl;

import dao.custom.CustomerDAO;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Customer> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Customer";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Customer>) list;
    }

    @Override
    public Customer search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.load(Customer.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public String generateCustomerId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT customerId FROM Customer order by customerId desc limit 1";
        Query query = session.createQuery(hql);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        for (String ids : list) {
            int temp = Integer.parseInt(ids.split("-")[1]);
            temp = temp + 1;
            if (temp <= 9) {
                return "C-00" + temp;
            } else if (temp < 99) {
                return "C-0" + temp;
            } else {
                return "C-" + temp;
            }
        }
        return "C-001";

    }

    @Override
    public ArrayList<String> getCustomerIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT customerId FROM Customer";
        Query query = session.createQuery(hql);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<String>) list;
    }

    @Override
    public boolean checkIfNicIsExists(String nic) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT customerNic from Customer where customerNic=:nic";
        Query query = session.createQuery(hql);
        query.setParameter("nic", nic);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        return list != null;
    }

    @Override
    public boolean ifCustomerExists(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Customer where customerId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        return list != null;
    }
}
