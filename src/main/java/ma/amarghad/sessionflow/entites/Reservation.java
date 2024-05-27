package ma.amarghad.sessionflow.entites;

import jakarta.persistence.*;
import lombok.*;
import ma.amarghad.sessionflow.enums.ReservationStatus;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Reservation {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @ManyToOne
    private Session session;
    @ManyToOne
    private Candidate candidate;
}