package ma.amarghad.sessionflow.service;

import ma.amarghad.sessionflow.dto.CandidateDto;

import java.util.List;

public interface CandidateService {
    CandidateDto registerCandidate(CandidateDto candidate);
    CandidateDto updateCandidate(CandidateDto candidate);

    CandidateDto getCandidateById(Long candidateId);

    CandidateDto getCandidateByUsername(String username);
    List<CandidateDto> getAllCandidates();
    void deleteCandidate(Long candidateId);
}
