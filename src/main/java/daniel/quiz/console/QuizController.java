package daniel.quiz.console;

import daniel.quiz.server.Question;
import daniel.quiz.server.QuizServer;

public class QuizController {

    private QuizConsoleView quizConsoleView;
    private QuizServer quizServer;

    public QuizController(QuizConsoleView quizConsoleView, QuizServer quizServer) {
        this.quizConsoleView = quizConsoleView;
        this.quizServer = quizServer;
    }

    public void startQuiz() {
        //pokazujemy zasady quizu
        quizConsoleView.showIntro();
        Question question = quizServer.getQuestion();
        quizConsoleView.showQuestion(question);
        String answer = quizConsoleView.readAnswer();
        String feedback = quizServer.checkAnswer(answer);
        quizConsoleView.showFeedback(feedback);
    }


}
