package pl.coderslab.carserv.entity;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = UserDetails.TABLE_NAME)
@Data
public class UserDetails {
    public final static String TABLE_NAME = "user_details";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(name = "Imię_użytkownika", nullable = false)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(name = "Nazwisko_użytkownika", nullable = false, length = 20)
    private String surname;

    @Email
    private String email;

    @Size(min = 7, max = 15)
    private int phoneNumber;
    private boolean businessUser;

    @PESEL
    @Column(length = 11)
    private String PESEL;
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
