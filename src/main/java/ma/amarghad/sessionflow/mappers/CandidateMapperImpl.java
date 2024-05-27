package ma.amarghad.sessionflow.mappers;

import ma.amarghad.sessionflow.dto.CandidateDto;
import ma.amarghad.sessionflow.entites.Candidate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CandidateMapperImpl implements CandidateMapper {
    @Override
    public CandidateDto toDto(Candidate entity) {
        CandidateDto candidateDto = new CandidateDto();
        BeanUtils.copyProperties(entity, candidateDto);
        return candidateDto;
    }

    @Override
    public Candidate toEntity(CandidateDto dto) {
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(dto, candidate);
        return candidate;
    }
}
