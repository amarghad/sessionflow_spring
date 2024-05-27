package ma.amarghad.sessionflow.mappers;

import ma.amarghad.sessionflow.dto.ReservationDto;
import ma.amarghad.sessionflow.entites.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapperImpl implements ReservationMapper {
    @Override
    public ReservationDto toDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        BeanUtils.copyProperties(reservation, reservationDto);
        return reservationDto;
    }

    @Override
    public Reservation toEntity(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDto, reservation);
        return reservation;
    }
}
