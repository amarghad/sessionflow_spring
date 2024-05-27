package ma.amarghad.sessionflow.service;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.JuryMemberDto;
import ma.amarghad.sessionflow.entites.JuryMember;
import ma.amarghad.sessionflow.mappers.JuryMapper;
import ma.amarghad.sessionflow.repository.JuryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RepositoryJuryService implements JuryService {

    private JuryRepository juryRepository;
    private JuryMapper juryMapper;
    @Override
    public List<JuryMemberDto> getAllJuryMembers() {
        return juryRepository.findAll().stream().map(juryMapper::toDto).toList();
    }

    @Override
    public JuryMemberDto addJuryMember(JuryMemberDto juryMemberDto) {
        JuryMember juryMember = juryMapper.toEntity(juryMemberDto);
        return juryMapper.toDto(juryRepository.save(juryMember));
    }

    @Override
    public void deleteJuryMember(Long memberId) {
        juryRepository.deleteById(memberId);
    }

}
