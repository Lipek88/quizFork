package daniel.quiz.console;

import daniel.quiz.server.QuizServer;

public class QuizController {

    private QuizView quizView;
    private QuizServer quizServer;

    public QuizController(QuizView quizView, QuizServer quizServer) {
        this.quizView = quizView;
        this.quizServer = quizServer;
    }

    public void startQuiz() {
        //pokazujemy zasady quizu
        quizView.showIntro();
    }


}
