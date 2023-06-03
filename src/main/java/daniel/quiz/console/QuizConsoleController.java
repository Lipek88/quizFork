package daniel.quiz.console;

import daniel.quiz.server.Question;
import daniel.quiz.server.QuizService;

public class QuizConsoleController {

    private QuizConsoleView quizConsoleView;
    private QuizService quizService;

    public QuizConsoleController(QuizConsoleView quizConsoleView, QuizService quizService) {
        this.quizConsoleView = quizConsoleView;
        this.quizService = quizService;
    }

    public void startQuiz() {
        //pokazujemy zasady quizu
        quizConsoleView.showIntro(quizService.getIntroText());
        executeQuestion();
        executeQuestion();
    }

    private void executeQuestion() {
        Question question = quizService.prepareQuestion();
        quizConsoleView.showQuestion(question);
        String answer = quizConsoleView.readAnswer();
        String feedback = quizService.userAnswered(answer);
        quizConsoleView.showFeedback(feedback);
        quizConsoleView.showCounter(quizService.howManyCorrect());
    }


}
