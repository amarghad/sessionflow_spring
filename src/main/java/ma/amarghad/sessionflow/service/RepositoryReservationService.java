package ma.amarghad.sessionflow.service;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.ReservationDto;
import ma.amarghad.sessionflow.entites.Candidate;
import ma.amarghad.sessionflow.entites.Reservation;
import ma.amarghad.sessionflow.entites.Session;
import ma.amarghad.sessionflow.enums.ReservationStatus;
import ma.amarghad.sessionflow.exception.NoSuffisantPossibleReservations;
import ma.amarghad.sessionflow.exception.ReservationNotFoundException;
import ma.amarghad.sessionflow.mappers.CandidateMapper;
import ma.amarghad.sessionflow.mappers.ReservationMapper;
import ma.amarghad.sessionflow.mappers.SessionMapper;
import ma.amarghad.sessionflow.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service @AllArgsConstructor
public class RepositoryReservationService implements ReservationService {

    private ReservationRepository reservationRepository;
    private CandidateService candidateService;
    private CandidateMapper candidateMapper;
    private ReservationMapper reservationMapper;
    private SessionMapper sessionMapper;
    private SessionService sessionService;

    @Override
    public ReservationDto makeReservation(String sessionId) {
        Session session = sessionMapper.toEntity(
                sessionService.getSessionById(sessionId)
        );
        long activeReservations = reservationRepository.countBySessionAndStatusNot(session, ReservationStatus.CANCELLED);

        if (session.getMax() <= activeReservations) {
            throw new NoSuffisantPossibleReservations();
        }

        //Candidate candidate = candidateMapper.toEntity(candidateService.getCandidateByUsername("mohamed"));

        Reservation reservation = new Reservation();
        reservation.setId(UUID.randomUUID().toString());
        reservation.setCandidate(null);
        reservation.setSession(session);
        reservation.setStatus(ReservationStatus.PENDING);

        return reservationMapper.toDto(reservationRepository.save(reservation));
    }

    @Override
    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationMapper.toEntity(
                getReservationById(reservationId)
        );
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }

    @Override
    public void confirmReservation(String reservationId) {
        Reservation reservation = reservationMapper.toEntity(
                getReservationById(reservationId)
        );
        reservation.setStatus(ReservationStatus.CONFIRMED);
        reservationRepository.save(reservation);
    }

    @Override
    public ReservationDto getReservationById(String reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(ReservationNotFoundException::new);
        return reservationMapper.toDto(reservation);
    }

    @Override
    public List<ReservationDto> getReservationsByCandidate(Long candidateId) {
        Candidate candidate = candidateMapper.toEntity(
                candidateService.getCandidateById(candidateId)
        );

        return reservationRepository.findByCandidate(candidate)
                .stream()
                .map(reservationMapper::toDto)
                .toList();
    }

    @Override
    public List<ReservationDto> getReservationsBySession(String sessionId) {
        Session session = sessionMapper.toEntity(sessionService.getSessionById(sessionId));
        return reservationRepository.findBySession(session)
                .stream()
                .map(reservationMapper::toDto)
                .toList();
    }
}
