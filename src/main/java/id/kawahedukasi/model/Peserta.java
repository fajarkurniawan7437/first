package id.kawahedukasi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "participant")
public class Peserta extends PanacheEntityBase {
    @Id //constraint primay key
    @SequenceGenerator(name = "participantSequence", sequenceName = "participant_sequence", allocationSize = 1, initialValue = 1)// untuk otomatis id
    @GeneratedValue(generator = "participantSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false) //meta informasi
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "email")
    public String email;
    @Column(name = "phone_number")
    public String phoneNumber;


}
