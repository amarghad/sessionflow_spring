package ma.amarghad.sessionflow.repository;

import ma.amarghad.sessionflow.entites.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByEmail(String email);

    Optional<Candidate> findByUsername(String username);
}
