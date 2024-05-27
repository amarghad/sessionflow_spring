package ma.amarghad.sessionflow.service;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.SessionDto;
import ma.amarghad.sessionflow.entites.Session;
import ma.amarghad.sessionflow.exception.SessionTimeSlotOutOfRange;
import ma.amarghad.sessionflow.mappers.SessionMapper;
import ma.amarghad.sessionflow.repository.SessionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @AllArgsConstructor
public class RepositorySessionService implements SessionService {

    private SessionMapper sessionMapper;
    private SessionRepository sessionRepository;
    private final LocalTime _08H00 = LocalTime.of(8, 0);
    private final LocalTime _12H00 = LocalTime.of(12, 0);
    private final LocalTime _14H00 = LocalTime.of(14, 0);
    private final LocalTime _18H00 = LocalTime.of(18, 0);

    @Override
    public SessionDto createSession(SessionDto sessionDto) {
        Session session = sessionMapper.toEntity(sessionDto);
        if (!(
            (session.getStart().isAfter(_08H00) && session.getEnd().isBefore(_12H00)) ||
            (session.getStart().isAfter(_14H00) && session.getEnd().isBefore(_18H00))
        )) {
            throw new SessionTimeSlotOutOfRange();
        }

        session.setId(UUID.randomUUID().toString());
        return sessionMapper.toDto(sessionRepository.save(session));
    }

    @Override
    public SessionDto updateSession(SessionDto sessionDto) {
        return null;
    }

    @Override
    public void deleteSession(String sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public SessionDto getSessionById(String sessionId) {
        Session session = sessionRepository.findById(sessionId).orElseThrow();
        return sessionMapper.toDto(session);
    }

    @Override
    public List<SessionDto> getNearestSessions(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return sessionRepository.getNearestSessions(pageable)
                .stream()
                .map(sessionMapper::toDto)
                .toList();
    }

    @Override
    public List<SessionDto> getSessionsByDate(LocalDate date) {
        return new ArrayList<>();
    }

    @Override
    public List<SessionDto> getAllSessions() {
        return sessionRepository.findAll().stream().map(sessionMapper::toDto).toList();
    }
}
