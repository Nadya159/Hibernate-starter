package by.javaguru.hibernate.starter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ticket", schema = "public")
public class Ticket {
    @Id
    @Column(name = "passport_no")
    private String passportNo;
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "flight_id")
    private Long flightId;
    @Column(name = "seat_no")
    private String seatNo;
    private BigDecimal cost;
}
