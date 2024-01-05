package by.javaguru;

import by.javaguru.dao.FlightDao;
import by.javaguru.entity.Aircraft;
import by.javaguru.entity.Airport;
import by.javaguru.entity.Flight;
import by.javaguru.entity.FlightStatus;
import by.javaguru.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class FlightDaoTest {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static FlightDao flightDao = FlightDao.getInstance();

    private static Flight flight = new FlightDaoTest().buildFlight();

    @BeforeAll
    static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @BeforeEach
    void setupThis() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @AfterEach
    void tearThis() {
        session.getTransaction().commit();
    }

    @AfterAll
    static void tear() {
        sessionFactory.close();
    }

    @Test
    void testSave() {
        assertTrue(flightDao.save(flight));
    }

    @Test
    void testUpdate() {
        assertTrue(flightDao.update(flight));
    }

    @Test
    void testDelete() {
        assertTrue(flightDao.delete(flight.getId()));
    }

    public Flight buildFlight() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        Airport airport1 = session.get(Airport.class, 3);
        Airport airport2 = session.get(Airport.class, 5);
        Aircraft aircraft = session.get(Aircraft.class, 4);

        var flight = Flight.builder()
                .flightNo("TEST123")
                .departureDate(LocalDateTime.of(2023, Month.DECEMBER,12,12,02))
                .departureAirportCode(airport1)
                .arrivalDate(LocalDateTime.of(2023, Month.DECEMBER,12,16,32))
                .arrivalAirportCode(airport2)
                .aircraft(aircraft)
                .status(FlightStatus.ARRIVED)
                .build();
        return flight;
    }
}