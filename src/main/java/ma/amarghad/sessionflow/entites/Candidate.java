package ma.amarghad.sessionflow.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Candidate extends User {
    @Column(unique = true)
    private String email;
    private String phone;
    @OneToMany(mappedBy = "candidate")
    private List<Reservation> reservations;
}
