package ma.amarghad.sessionflow.repository;

import ma.amarghad.sessionflow.entites.Candidate;
import ma.amarghad.sessionflow.entites.Reservation;
import ma.amarghad.sessionflow.entites.Session;
import ma.amarghad.sessionflow.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByCandidate(Candidate candidate);
    List<Reservation> findBySession(Session session);

    long countByStatusEquals(ReservationStatus reservationStatus);
    long countBySessionAndStatusNot(Session session, ReservationStatus status);
}
