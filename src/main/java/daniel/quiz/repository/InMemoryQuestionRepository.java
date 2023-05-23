package daniel.quiz.repository;

import daniel.quiz.server.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryQuestionRepository {

    private List<Question> questions = new ArrayList<>();

    public void add(Question question) {
        questions.add(question);
    }

    public Optional<Question> findQuestionBy(int number) {
        return questions.stream()
                .filter(question -> question.getNumber() == number)
                .findFirst();
    }




}
