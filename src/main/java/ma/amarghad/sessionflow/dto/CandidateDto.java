package ma.amarghad.sessionflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data @AllArgsConstructor @NoArgsConstructor
public class CandidateDto extends UserDto {
    private String email;
    private String phone;
}
