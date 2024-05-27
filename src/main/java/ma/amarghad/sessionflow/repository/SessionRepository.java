package ma.amarghad.sessionflow.repository;

import ma.amarghad.sessionflow.entites.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, String> {

    @Query("SELECT s FROM Session s WHERE (SELECT COUNT(r) FROM s.reservations r WHERE r.status <> 'CANCELLED') < s.max ORDER BY s.date, s.start ASC")
    List<Session> getNearestSessions(Pageable pageable);

}
