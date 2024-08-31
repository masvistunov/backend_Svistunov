package t1.debute.techradar.rest.dto;

import lombok.Builder;
import lombok.Data;
import t1.debute.techradar.entity.Participant;

@Data
@Builder
public class ParticipantDTO {
    private Long id;
    private String username;
    private long question_id;

    public static ParticipantDTO fromParticipant(Participant participant){
        return ParticipantDTO.builder().id(participant.getParticipant_id()).username(participant.getParticipant_name()).build();
    }
}
