package t1.debute.techradar.rest.dto;

import lombok.Builder;
import lombok.Data;
import t1.debute.techradar.entity.Question;

@Data
@Builder
public class QuestionDTO {
    private Long id;
    private String description;
    private int questionVariant;
    private String category;
    private String topic;
    private boolean active;

    static public QuestionDTO fromQuestion(Question question){
        return QuestionDTO.builder().category(question.getCategory()).active(question.isActive()).questionVariant(question.getQuestionVariant()).description(question.getDescription()).topic(question.getTopic()).id(question.getId()).build();
    }
}