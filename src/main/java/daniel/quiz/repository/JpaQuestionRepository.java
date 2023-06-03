package daniel.quiz.repository;

import daniel.quiz.server.Question;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Primary
public interface JpaQuestionRepository extends JpaRepository<Question, Integer>,  QuestionRepository {
    @Override
    default void add(Question question) {
        save(question);
    }

    @Override
    default Optional<Question> findQuestionBy(int number) {
        return findById(number);
    }
}
