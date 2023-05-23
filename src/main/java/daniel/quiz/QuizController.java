package daniel.quiz;

import daniel.quiz.server.Question;
import daniel.quiz.server.QuizServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuizController {

    private QuizServer quizServer;

    public QuizController(QuizServer quizServer) {
        this.quizServer = quizServer;
    }

    @GetMapping("/")
    public ModelAndView getQuizPage() {
        List<String> intro = quizServer.getIntroText();
        ModelAndView modelAndView = new ModelAndView("quiz.html");
        modelAndView.addObject("intro", intro);
        Question question = quizServer.prepareQuestion();
        modelAndView.addObject("question",question);
        return modelAndView;
    }

 /*   private void executeQuestion() {
        Question question = quizServer.prepareQuestion();
        quizConsoleView.showQuestion(question);
        String answer = quizConsoleView.readAnswer();
        String feedback = quizServer.userAnswered(answer);
        quizConsoleView.showFeedback(feedback);
        quizConsoleView.showCounter(quizServer.howManyCorrect());
    }*/



}
