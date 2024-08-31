package t1.debute.techradar.rest.dto;

import lombok.Builder;
import lombok.Data;
import t1.debute.techradar.entity.Answer;
@Data
@Builder
public class AnswerDTO {
    private Long id;
    private long question_id;
    private String  answer;
    private Boolean active;

    public static AnswerDTO fromAnswer(Answer answer){
         return AnswerDTO.builder().id(answer.getId()).question_id(answer.getQuestion().getId()).answer(answer.getAnswer()).active(answer.getActive()).build();
    }
}
