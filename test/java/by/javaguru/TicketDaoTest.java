package by.javaguru;

import by.javaguru.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class TicketDaoTest {
    private static SessionFactory sessionFactory;
    private static Session session;

    @BeforeAll
    static void setup() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
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
    public void testSave() {
        Ticket ticket = new TicketDaoTest().buildTicket();
        Assertions.assertNull(ticket.getId());
        session.persist(ticket);
        Assertions.assertNotNull(ticket.getId());
    }

    public Ticket buildTicket() {
        var ticket = Ticket.builder()
                .passportNo("test123")
                .passengerName("Test Test")
                .flightId(2L)
                .seatNo("A2")
                .cost(BigDecimal.valueOf(175.00))
                .build();
        return ticket;
    }
}
