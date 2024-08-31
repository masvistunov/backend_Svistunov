package t1.debute.techradar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import t1.debute.techradar.entity.Answer;
import t1.debute.techradar.entity.Question;

import java.util.List;

@Repository

public interface AnswerRepository extends CrudRepository<Answer,Long> {

    List<Answer> findAllByQuestion(Question question);
    Answer findFirstById(long id);
    void deleteAllByQuestion(Question question);
}
