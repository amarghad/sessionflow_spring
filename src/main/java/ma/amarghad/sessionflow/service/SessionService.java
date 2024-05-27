package ma.amarghad.sessionflow.service;
import ma.amarghad.sessionflow.dto.SessionDto;
import ma.amarghad.sessionflow.entites.JuryMember;
import ma.amarghad.sessionflow.entites.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SessionService {

    SessionDto createSession(SessionDto sessionDto);
    SessionDto updateSession(SessionDto sessionDto);
    void deleteSession(String sessionId);
    SessionDto getSessionById(String sessionId);

    List<SessionDto> getNearestSessions(int max);

    List<SessionDto> getSessionsByDate(LocalDate date);

    List<SessionDto> getAllSessions();
}