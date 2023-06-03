package daniel.quiz.repository;

import daniel.quiz.server.Question;

import java.util.Optional;

public interface QuestionRepository {
    void add(Question question);

    Optional<Question> findQuestionBy(int number);

}
