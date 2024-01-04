package by.javaguru.dao;

import by.javaguru.entity.Airport;
import by.javaguru.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class AirportDao implements Dao<String, Airport> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final AirportDao INSTANCE = new AirportDao();

    @Override
    public boolean save(Airport airport) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.persist(airport);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean update(Airport airport) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.merge(airport);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.delete(session.get(Airport.class, id));
            transaction.commit();
            return true;
        }
    }

    @Override
    public List<Airport> findAll() {
        try (var session = sessionFactory.getCurrentSession();) {
            return session.createQuery("from Airport", Airport.class).list();
        }
    }

    @Override
    public Optional<Airport> findById(String id) {
        try (var session = sessionFactory.getCurrentSession()) {
            Airport airport = session.get(Airport.class, id);
            return Optional.ofNullable(airport);
        }
    }

    public static AirportDao getInstance() {
        return INSTANCE;
    }

    private AirportDao() {
    }
}
