package ma.amarghad.sessionflow.repository;

import ma.amarghad.sessionflow.entites.JuryMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuryRepository extends JpaRepository<JuryMember, Long> {
}
