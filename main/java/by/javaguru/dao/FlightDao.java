package by.javaguru.dao;

import by.javaguru.entity.Flight;
import by.javaguru.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final FlightDao INSTANCE = new FlightDao();

    @Override
    public boolean save(Flight flight) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.persist(flight);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean update(Flight flight) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.merge(flight);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.delete(session.get(Flight.class, id));
            transaction.commit();
            return true;
        }
    }

    @Override
    public List<Flight> findAll() {
        try (var session = sessionFactory.getCurrentSession();) {
            return session.createQuery("from Flight", Flight.class).list();
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        try (var session = sessionFactory.getCurrentSession()) {
            Flight flight = session.get(Flight.class, id);
            return Optional.ofNullable(flight);
        }
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private FlightDao() {
    }
}
