package t1.debute.techradar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import t1.debute.techradar.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
    List<Question> findAllByTopicLikeIgnoreCase(String filter);
    Question findFirstByTopicLikeIgnoreCase(String filter);
    List<Question> findAllByActive(Boolean active);
}
