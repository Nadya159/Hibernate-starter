package by.javaguru.dao;

import by.javaguru.entity.Ticket;
import by.javaguru.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final TicketDao INSTANCE = new TicketDao();

    @Override
    public boolean save(Ticket ticket) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean update(Ticket ticket) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.delete(session.get(Ticket.class, id));
            transaction.commit();
            return true;
        }
    }

    @Override
    public List<Ticket> findAll() {
        try (var session = sessionFactory.getCurrentSession();) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        try (var session = sessionFactory.getCurrentSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            return Optional.ofNullable(ticket);
        }
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    private TicketDao() {
    }

}
