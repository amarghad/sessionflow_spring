package ma.amarghad.sessionflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.amarghad.sessionflow.entites.JuryMember;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class SessionDto {
    private String id;
    private Date date;
    private int max;
    private LocalTime start;
    private LocalTime end;
    private List<JuryMemberDto> juryMembers;
}
