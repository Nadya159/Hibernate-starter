package by.javaguru.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_no")
    private String flightNo;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @ManyToOne
    @JoinColumn
    private Airport departureAirportCode;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Airport arrivalAirportCode;

    @ManyToOne
    @JoinColumn
    private Aircraft aircraft;

    @Column(name = "status")
    private FlightStatus status;
}
