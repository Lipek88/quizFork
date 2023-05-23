package daniel.quiz.server;

import daniel.quiz.repository.InMemoryQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class QuestionFactory {
    private InMemoryQuestionRepository repository;

    public QuestionFactory(InMemoryQuestionRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void fillRepository() {
        //przygotowanie bazy pytań
        Question question1 = new Question("Czy jedna klasa może rozszerzać " +
                "wiele interfejsów?", "Tak",
                "Poprawna odpowiedź: można implementować wiele interfejsów a tylko po " +
                        "jednej klasie na raz dziedziczyny");

        Question question2 = new Question("Ile mamy typów prymitywnych?", "8",
                "Poprawna odpowiedź: 8, typy te to: byte, short, int, long," +
                        " float, double, boolean, char");

        repository.add(question1);
        repository.add(question2);
    }
}
