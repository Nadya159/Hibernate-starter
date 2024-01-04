package by.javaguru.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(SeatId.class)
@Table(name = "seat", schema = "public")
public class Seat {
    @Id
    @Column(name = "aircraft_id")
    private Aircraft aircraft;
    @Id
    @Column(name = "seat_no")
    private String seatNo;
}
