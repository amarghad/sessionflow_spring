package ma.amarghad.sessionflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.amarghad.sessionflow.enums.ReservationStatus;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationDto {
    private String id;
    private ReservationStatus status;
    private CandidateDto candidateDto;
}