package t1.debute.techradar.service;

import t1.debute.techradar.rest.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {
    List<AnswerDTO> getAllAnswers();
    AnswerDTO getAnswer(long id);
    AnswerDTO createNewAnswer(long question_id,String answer);
    void deleteAnswer(long id);
    List<AnswerDTO> getListOfAnswersByQuestionId(long id);
    void updateAnswersByQuestion(long question_id,String answer);

    void updateAnswerById(long id, boolean active, String answer);}