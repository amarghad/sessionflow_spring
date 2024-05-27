package ma.amarghad.sessionflow.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity @Builder @Data @AllArgsConstructor @NoArgsConstructor
public class Session {
    @Id
    private String id;

    private Date date;
    private int max;
    private LocalTime start;
    private LocalTime end;
    @OneToMany(mappedBy = "session")
    private List<Reservation> reservations;
    @OneToMany(fetch = FetchType.EAGER)
    private List<JuryMember> juryMembers;
}
