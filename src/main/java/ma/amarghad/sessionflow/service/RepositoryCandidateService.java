package ma.amarghad.sessionflow.service;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.entites.Candidate;
import ma.amarghad.sessionflow.dto.CandidateDto;
import ma.amarghad.sessionflow.exception.CandidateNotFoundException;
import ma.amarghad.sessionflow.mappers.CandidateMapper;
import ma.amarghad.sessionflow.repository.CandidateRepository;
import ma.amarghad.sessionflow.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class RepositoryCandidateService implements CandidateService {

    private CandidateRepository candidateRepository;
    private CandidateMapper candidateMapper;

    @Override
    public CandidateDto registerCandidate(CandidateDto candidateDto) {
        Candidate candidate = candidateMapper.toEntity(candidateDto);
        return candidateMapper.toDto(candidateRepository.save(candidate));
    }

    @Override
    public CandidateDto updateCandidate(CandidateDto candidateDto) {
        Candidate candidate = candidateMapper.toEntity(candidateDto);
        return candidateMapper.toDto(candidateRepository.save(candidate));
    }

    @Override
    public CandidateDto getCandidateById(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(CandidateNotFoundException::new);
        return candidateMapper.toDto(candidate);
    }

    @Override
    public CandidateDto getCandidateByUsername(String username) {
        Candidate candidate = candidateRepository.findByUsername(username).orElseThrow(CandidateNotFoundException::new);
        return candidateMapper.toDto(candidate);
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        return candidateRepository.findAll().stream().map(candidateMapper::toDto).toList();
    }

    @Override
    public void deleteCandidate(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}
