package ma.amarghad.sessionflow.web;

import lombok.AllArgsConstructor;
import ma.amarghad.sessionflow.dto.JuryMemberDto;
import ma.amarghad.sessionflow.service.JuryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("jury")
public class JuryController {

    private JuryService juryService;

    @GetMapping
    List<JuryMemberDto> index() {
        return juryService.getAllJuryMembers();
    }

    @PostMapping
    JuryMemberDto create(@RequestBody JuryMemberDto juryMemberDto) {
        return juryService.addJuryMember(juryMemberDto);
    }

    @DeleteMapping("{memberId}")
    void delete(@PathVariable Long memberId) {
        juryService.deleteJuryMember(memberId);
    }

}
