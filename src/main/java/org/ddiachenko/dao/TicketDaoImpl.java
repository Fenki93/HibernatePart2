package org.ddiachenko.dao;

import org.ddiachenko.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ddiachenko.entity.Ticket;

import java.util.List;
import java.util.Objects;

public class TicketDaoImpl implements TicketDao{

    @Override
    public Ticket findById(Long id) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Ticket findByClientId(Long id) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket c WHERE c.client.id = :id", Ticket.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findByPlanetFrom(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket c WHERE c.fromPlanet.id = :planetId", Ticket.class)
                    .setParameter("planetId", planetId)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findByPlanetTo(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket c WHERE c.toPlanet.id = :planetId", Ticket.class)
                    .setParameter("planetId", planetId)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Ticket ticket) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(ticket);
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
    public boolean update(Ticket ticket) {
        boolean result = false;
        if (Objects.isNull(ticket.getId())) {
            return false;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(ticket);
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
    public void delete(Ticket ticket) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(ticket);
            tx.commit();
        }
    }
}