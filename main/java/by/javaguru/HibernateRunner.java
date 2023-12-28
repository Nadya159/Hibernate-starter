package by.javaguru;

import by.javaguru.dao.TicketDao;
import by.javaguru.entity.Ticket;
import by.javaguru.util.HibernateUtil;

import java.math.BigDecimal;

public class HibernateRunner {
    public static void main(String[] args) {
        var sessionFactory = HibernateUtil.getSessionFactory();
        TicketDao ticketDao = TicketDao.getInstance();
        System.out.println(ticketDao.save(Ticket.builder()
                .passportNo("555321")
                .passengerName("Екатерина Петренко")
                .flightId(2L)
                .seatNo("A2")
                .cost(BigDecimal.valueOf(1))
                .build()));
        sessionFactory.close();
    }
}
