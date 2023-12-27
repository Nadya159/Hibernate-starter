package by.javaguru;

import by.javaguru.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

public class HibernateRunner {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        //configuration.addAnnotatedClass(Ticket.class);
        //configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession();) {
            session.beginTransaction();

            System.out.println(session.save(Ticket.builder()
                    .passportNo("555321")
                    .passengerName("Екатерина Петренко")
                    .flightId(2L)
                    .seatNo("A2")
                    .cost(BigDecimal.valueOf(1))
                    .build()));
            session.getTransaction().commit();
        }
    }
}
