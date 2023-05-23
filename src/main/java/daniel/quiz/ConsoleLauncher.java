package daniel.quiz;

import daniel.quiz.console.QuizController;
import daniel.quiz.console.QuizConsoleView;
import daniel.quiz.server.QuizServer;

public class ConsoleLauncher {

    public static void main(String[] args) {
        //pokaz ze jesteśmy w quizie
        QuizConsoleView quizConsoleView = new QuizConsoleView();
        QuizServer quizServer = new QuizServer();
        QuizController quizController = new QuizController(quizConsoleView,quizServer);
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
