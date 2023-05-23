package daniel.quiz.console;

import daniel.quiz.server.Question;

import java.util.Scanner;

public class QuizConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public void showIntro() {
        System.out.println("Rozpoczynasz quiz z javy!");
        System.out.println("Quiz ma na celu pomóc Ci przećwiczyć swoje odpowiedzi na pytania z najważniejszych dziedzin" +
                "programowania w javie.");
        System.out.println("Po każdym pytaniu zobaczysz poprawną odpowiedź");
        System.out.println();
    }


    public void showQuestion(Question question) {
        System.out.println(question.getDescription());
    }

    public String readAnswer() {
        return scanner.nextLine();
    }

    public void showFeedback(String feedback) {
        System.out.println(feedback);
        System.out.println();
    }
}
