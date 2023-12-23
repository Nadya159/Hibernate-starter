package by.javaguru.hibernate.starter.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.javaguru.hibernate.starter.entity.Ticket;

import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket> {
    private final Configuration configuration = new Configuration();
    private final SessionFactory sessionFactory = configuration.buildSessionFactory();
    private static final TicketDao INSTANCE = new TicketDao();

    @Override
    public boolean save(Ticket ticket) {
        try (var session = sessionFactory.openSession();) {
            var transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean update(Ticket ticket) {
        try (var session = sessionFactory.openSession();) {
            var transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            session.delete(session.get(Ticket.class, id));
            return true;
        }
    }

    @Override
    public List<Ticket> findAll() {
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession();) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        try (var session = sessionFactory.openSession()) {
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

