package org.ddiachenko.dao;

import org.ddiachenko.entity.Client;
import org.ddiachenko.entity.Planet;
import org.ddiachenko.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Objects;

public class ClientDaoImpl implements ClientDao {

    private final SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();

    @Override
    public boolean createClient(Client client) {
        boolean result = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                client.setId(null);
                session.persist(client);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }


    @Override
    public boolean updateClient(Client client) {
        boolean result = false;
        if (Objects.isNull(client.getId())) {
            return false;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(client);
                transaction.commit();
                result = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public Client getClientById(Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, clientId);
        }
    }

    @Override
    public void deleteClientById(Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet existing = session.get(Planet.class, clientId);
            session.remove(existing);
            transaction.commit();
        }
    }
}