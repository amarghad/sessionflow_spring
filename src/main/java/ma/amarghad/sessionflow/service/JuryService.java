package ma.amarghad.sessionflow.service;

import ma.amarghad.sessionflow.dto.JuryMemberDto;
import ma.amarghad.sessionflow.entites.JuryMember;

import java.util.List;

public interface JuryService {

    List<JuryMemberDto> getAllJuryMembers();

    JuryMemberDto addJuryMember(JuryMemberDto juryMemberDto);

    void deleteJuryMember(Long memberId);
}
