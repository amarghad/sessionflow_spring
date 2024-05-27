package ma.amarghad.sessionflow.web;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.ReservationDto;
import ma.amarghad.sessionflow.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("reservations")
public class ReservationController {

    private ReservationService reservationService;

    @PostMapping
    ReservationDto makeReservation(@RequestBody String sessionId) {
        return reservationService.makeReservation(sessionId);
    }

    @PutMapping("{reservationId}/cancel")
    void cancelReservation(@PathVariable String reservationId) {
        reservationService.cancelReservation(reservationId);
    }

    @PutMapping("{reservationId}/confirm")
    void confirmReservation(@PathVariable String reservationId) {
        reservationService.confirmReservation(reservationId);
    }



}
