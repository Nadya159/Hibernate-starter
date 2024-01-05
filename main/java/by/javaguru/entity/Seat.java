package by.javaguru.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(SeatId.class)
@Table(name = "seat")
public class Seat implements Serializable {
    @Id
    @ManyToOne
    private Aircraft aircraft;

    @Id
    @Column(name = "seat_no")
    private String seatNo;
}
