package t1.debute.techradar.service;

import t1.debute.techradar.rest.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    QuestionDTO createNewQuestion(String description, int questionVariant, boolean active, String object,String category);
    void deleteQuestion(long id);
    void updateQuestion(long id, String description, int questionVariant, boolean active, String topic,String category);
    List<QuestionDTO> getAllQuestion(String filter);
}