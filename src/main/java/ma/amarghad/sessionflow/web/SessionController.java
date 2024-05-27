package ma.amarghad.sessionflow.web;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.ReservationDto;
import ma.amarghad.sessionflow.dto.SessionDto;
import ma.amarghad.sessionflow.service.ReservationService;
import ma.amarghad.sessionflow.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("sessions")
public class SessionController {

    private SessionService sessionService;
    private ReservationService reservationService;

    @GetMapping
    List<SessionDto> getSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("{sessionId}")
    SessionDto getSessionById(@PathVariable String sessionId) {
        return sessionService.getSessionById(sessionId);
    }

    @GetMapping("nearest")
    List<SessionDto> getNearestSessions() {
        return sessionService.getNearestSessions(2);
    }

    @PostMapping
    SessionDto createSession(@RequestBody SessionDto sessionDto) {
        return sessionService.createSession(sessionDto);
    }

    @DeleteMapping("{sessionId}")
    void deleteSession(@PathVariable String sessionId) {
        sessionService.deleteSession(sessionId);
    }

    @GetMapping("{sessionId}/reservations")
    List<ReservationDto> getSessionReservations(@PathVariable String sessionId) {
        return reservationService.getReservationsBySession(sessionId);
    }

}
