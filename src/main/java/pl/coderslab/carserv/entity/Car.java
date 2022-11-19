package pl.coderslab.carserv.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = Car.TABLE_NAME)
@Data

public class Car {
    public final static String TABLE_NAME = "cars";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String model;
    private String registrationPlate;
    @Column(unique = true, length = 17)
    private String VIN;
    private Date yearOfProduction;
    private String fuelType;
    private int mileage;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }


}
