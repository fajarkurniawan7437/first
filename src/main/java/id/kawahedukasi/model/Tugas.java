package id.kawahedukasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
@Entity
@Table(name = "tugas")
public class Tugas extends PanacheEntityBase {
    @Id //constraint primay key
    @SequenceGenerator(name = "tugasSequence", sequenceName = "tugas_sequence", allocationSize = 1, initialValue = 1)// untuk otomatis id
    @GeneratedValue(generator = "tugasSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false) //meta informasi
    public Long id;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "score", nullable = false)
    public Integer score;
    @ManyToOne()
    @JoinColumn(name = "participant_id")
    public Peserta peserta;
}
