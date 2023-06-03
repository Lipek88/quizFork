package daniel.quiz.server;

import daniel.quiz.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class QuestionFactory {
    private QuestionRepository repository;

    public QuestionFactory(QuestionRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void fillRepository() {
        //przydałoby się zabezpieczyć żeby nie dodawał pytań jeśli repo jest puste
        //aktualne generowanie id przez baze danych nie gwarantuje odpowiednich wartości, może lepiej przekazywać
        //id w konstruktorze lub dostosować generator
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
