package by.javaguru;

import by.javaguru.dao.TicketDao;
import by.javaguru.entity.Ticket;
import by.javaguru.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TicketDaoTest {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static  TicketDao ticketDao = TicketDao.getInstance();

    private static Ticket ticket = new TicketDaoTest().buildTicket();

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
        assertTrue(ticketDao.save(ticket));
    }

    @Test
    void testUpdate() {
        assertTrue(ticketDao.update(ticket));
    }

    @Test
    void testDelete() {
        assertTrue(ticketDao.delete(ticket.getId()));
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
