package by.javaguru.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data

public class SeatId implements Serializable {

    private Aircraft aircraft;

    private String seatNo;
}
