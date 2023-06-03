package daniel.quiz;

import daniel.quiz.console.QuizConsoleController;
import daniel.quiz.console.QuizConsoleView;
import daniel.quiz.repository.InMemoryQuestionRepository;
import daniel.quiz.server.QuestionFactory;
import daniel.quiz.server.QuizService;

public class ConsoleLauncher {

    public static void main(String[] args) {
        //pokaz ze jesteśmy w quizie
        QuizConsoleView quizConsoleView = new QuizConsoleView();
        InMemoryQuestionRepository repository = new InMemoryQuestionRepository();
        QuestionFactory factory = new QuestionFactory(repository);
        factory.fillRepository();
        QuizService quizService = new QuizService(repository);
        QuizConsoleController quizConsoleController = new QuizConsoleController(quizConsoleView, quizService);
        quizConsoleController.startQuiz();
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
