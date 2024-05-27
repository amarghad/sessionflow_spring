package ma.amarghad.sessionflow.mappers;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.SessionDto;
import ma.amarghad.sessionflow.entites.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionMapperImpl implements SessionMapper {

    private JuryMapper juryMapper;

    @Override
    public SessionDto toDto(Session session) {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setJuryMembers(
            session.getJuryMembers().stream().map(juryMapper::toDto).toList()
        );
        BeanUtils.copyProperties(session, sessionDto);
        return sessionDto;
    }

    @Override
    public Session toEntity(SessionDto sessionDto) {
        Session session = new Session();
        BeanUtils.copyProperties(sessionDto, session);
        return session;
    }
}
