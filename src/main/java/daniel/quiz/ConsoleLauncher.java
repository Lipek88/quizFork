package daniel.quiz;

import daniel.quiz.console.QuizController;
import daniel.quiz.console.QuizConsoleView;
import daniel.quiz.repository.InMemoryQuestionRepository;
import daniel.quiz.server.Question;
import daniel.quiz.server.QuizServer;

public class ConsoleLauncher {

    public static void main(String[] args) {
        //pokaz ze jesteśmy w quizie
        QuizConsoleView quizConsoleView = new QuizConsoleView();
        InMemoryQuestionRepository repository = new InMemoryQuestionRepository();
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
        QuizServer quizServer = new QuizServer(repository);
        QuizController quizController = new QuizController(quizConsoleView, quizServer);
        quizController.startQuiz();
    }
}



/*

Mvp quiz edukacyjny z javy:
Zobaczenie pytań z javy
Udzielenie odpowiedzi (pytania zamknięte)
Pokazanie poprawnej odpowiedzi i uzasadnienia

Future features:
Zobaczenie ogólnego wyniku - podsumowanie serii pytań
Kilka różnych testów
dopasowywanie poziomu trudności
...

* */
