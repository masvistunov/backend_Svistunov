package t1.debute.techradar.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.debute.techradar.entity.Answer;
import t1.debute.techradar.entity.Question;
import t1.debute.techradar.repository.AnswerRepository;
import t1.debute.techradar.repository.QuestionRepository;
import t1.debute.techradar.rest.dto.AnswerDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerServiceImpl implements AnswerService{
@Autowired
    AnswerRepository repository;
@Autowired
    QuestionRepository questionRepository;
    @Override
    public List<AnswerDTO> getAllAnswers() {
        return StreamSupport.stream( repository.findAll().spliterator(),false).map(AnswerDTO::fromAnswer).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public AnswerDTO getAnswer(long id) {
        return AnswerDTO.fromAnswer(repository.findFirstById(id));
    }

    @Override
    public AnswerDTO createNewAnswer(long question_id,String  answer) {
        Optional<Question> question = questionRepository.findById(question_id);
        if (question.isPresent()) {
            log.info("question is present");
            log.info("createAnswer" + question.get());
            if(answer !=null && !answer.isBlank()){
                log.info("answer not null");
                return AnswerDTO.fromAnswer( repository.save(new Answer(null,question.get(),answer,true)));
        }else{
                throw new RuntimeException("");
            }
        }

        else{
            log.info("question with id " + question_id + "does not exist");
            throw new RuntimeException("Error in createNewAnswer, question not exists!");
        }
    }

    @Override
    public void deleteAnswer(long id) {
        Optional<Answer> answer = repository.findById(id);
        if(answer.isPresent()){
            Answer realAnswer = answer.get();
            realAnswer.setActive(false);
            repository.save(realAnswer);
        }

    }

    @Override
    public List<AnswerDTO> getListOfAnswersByQuestionId(long id) {
        return repository.findAllByQuestion(questionRepository.findById(id).get()).stream().map(AnswerDTO::fromAnswer).toList();
    }

    @Override
    public void updateAnswersByQuestion(long question_id,String asnwer) {
        Optional<Question> question = questionRepository.findById(question_id);
        if(question.isPresent()){

        Optional<List<Answer>> answers = Optional.ofNullable(repository.findAllByQuestion(question.get()));
            if(answers.isPresent()){
                List<Answer> realAnswers = answers.get();
                StreamSupport.stream(realAnswers.spliterator(), false).forEach(ar->ar.setActive(true));
                StreamSupport.stream(realAnswers.spliterator(), false).forEach(ar->repository.save(ar));
        }
        }
    }

    @Override
    public void updateAnswerById(long id,boolean active,String answer) {
        Optional<Answer> updateanswer = repository.findById(id);
        if(updateanswer.isPresent()){
            Answer realAnswer = updateanswer.get();
            realAnswer.setActive(false);
            repository.save(realAnswer);
        }
    }


}
