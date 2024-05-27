package ma.amarghad.sessionflow.mappers;

import ma.amarghad.sessionflow.dto.JuryMemberDto;
import ma.amarghad.sessionflow.entites.JuryMember;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class JuryMapperImpl implements JuryMapper {
    @Override
    public JuryMemberDto toDto(JuryMember juryMember) {
        JuryMemberDto juryMemberDto = new JuryMemberDto();
        BeanUtils.copyProperties(juryMember, juryMemberDto);
        return juryMemberDto;
    }

    @Override
    public JuryMember toEntity(JuryMemberDto juryMemberDto) {
        JuryMember juryMember = new JuryMember();
        BeanUtils.copyProperties(juryMemberDto, juryMember);
        return juryMember;
    }
}
