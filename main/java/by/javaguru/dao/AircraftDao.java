package by.javaguru.dao;

import by.javaguru.entity.Aircraft;
import by.javaguru.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class AircraftDao implements Dao<Integer, Aircraft> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final AircraftDao INSTANCE = new AircraftDao();


    @Override
    public boolean save(Aircraft aircraft) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.persist(aircraft);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean update(Aircraft aircraft) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.merge(aircraft);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            session.delete(session.get(Aircraft.class, id));
            transaction.commit();
            return true;
        }
    }

    @Override
    public List<Aircraft> findAll() {
        try (var session = sessionFactory.getCurrentSession();) {
            return session.createQuery("from Aircraft", Aircraft.class).list();
        }
    }

    @Override
    public Optional<Aircraft> findById(Integer id) {
        try (var session = sessionFactory.getCurrentSession()) {
            Aircraft aircraft = session.get(Aircraft.class, id);
            return Optional.ofNullable(aircraft);
        }
    }

    public static AircraftDao getInstance() {
        return INSTANCE;
    }

    private AircraftDao() {
    }
}

