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
@Table(name = "airport")
public class Airport implements Serializable {
    @Id
    private String code;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;
}
