package t1.debute.techradar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.debute.techradar.entity.Answer;
import t1.debute.techradar.entity.Question;
import t1.debute.techradar.repository.AnswerRepository;
import t1.debute.techradar.repository.QuestionRepository;
import t1.debute.techradar.rest.dto.QuestionDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository repository;
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public QuestionDTO createNewQuestion(String description, int questionVariant, boolean active, String topic,String category) {
        return QuestionDTO.fromQuestion(repository.save(new Question(null,questionVariant,description,category,topic,active)));
    }


    @Override
    public void deleteQuestion(long id) {
        Optional<Question> question = repository.findById(id);
        if (question.isPresent()) {
            Question realQuestion = question.get();
            realQuestion.setActive(false);
            repository.save(realQuestion);
            Optional<List<Answer>> answer = Optional.ofNullable(answerRepository.findAllByQuestion(question.get()));
            if (answer.isPresent()){
                answerRepository.deleteAllByQuestion(question.get());
            }
        }
    }

    @Override
    public void updateQuestion(long id, String description, int questionVariant, boolean active, String topic,String category) {
        Optional<Question> question = repository.findById(id);
        if(question.isPresent()){
            if(active == true){
                StreamSupport.stream( answerRepository.findAllByQuestion(question.get()).spliterator(),false).forEach(ar->ar.setActive(true));
            }else{StreamSupport.stream( answerRepository.findAllByQuestion(question.get()).spliterator(),false).forEach(ar->ar.setActive(false));}

            repository.save(new Question(id,questionVariant,description,category,topic,active));}
    }

    @Override
    public List<QuestionDTO> getAllQuestion(String filter) {
        if(filter != null && !filter.isBlank()){
            if(filter.equalsIgnoreCase("true")||filter.equalsIgnoreCase("false")){
                return repository.findAllByActive(Boolean.valueOf(filter)).stream().map(QuestionDTO::fromQuestion).collect(Collectors.toList());
            }else return repository.findAllByTopicLikeIgnoreCase(filter).stream().map(QuestionDTO::fromQuestion).collect(Collectors.toList());
        }else{
            return StreamSupport.stream(repository.findAll().spliterator(),false).map(QuestionDTO::fromQuestion).collect(Collectors.toList());
        }
    }


}
