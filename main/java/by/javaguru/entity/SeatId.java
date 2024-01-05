package by.javaguru.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data

public class SeatId implements Serializable {

    private Aircraft aircraft;

    private String seatNo;
}
