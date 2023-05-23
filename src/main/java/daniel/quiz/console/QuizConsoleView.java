package daniel.quiz.console;

import daniel.quiz.server.Question;

import java.util.List;
import java.util.Scanner;

public class QuizConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public void showIntro(List<String> messages) {
        for (String message : messages) {
            System.out.println(message);
        }
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

    public void showCounter(int howManyCorrect) {
        System.out.println("Poprawnych odpowiedzi: " + howManyCorrect);
    }
}
