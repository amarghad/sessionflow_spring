package ma.amarghad.sessionflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public abstract class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
}