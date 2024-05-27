package ma.amarghad.sessionflow.service;

import ma.amarghad.sessionflow.dto.ReservationDto;
import ma.amarghad.sessionflow.entites.Reservation;

import java.util.List;

public interface ReservationService {

    ReservationDto makeReservation(String seanceId);
    void cancelReservation(String reservationId);
    void confirmReservation(String reservationId);
    ReservationDto getReservationById(String reservationId);
    List<ReservationDto> getReservationsByCandidate(Long candidateId);
    List<ReservationDto> getReservationsBySession(String sessionId);

}
