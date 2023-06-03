package daniel.quiz.spring;

import daniel.quiz.server.Question;
import daniel.quiz.server.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuizMvcController {

    private QuizService quizService;

    public QuizMvcController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public ModelAndView getQuizPage() {
        List<String> intro = quizService.getIntroText();
        ModelAndView modelAndView = new ModelAndView("quiz.html");
        modelAndView.addObject("intro", intro);
        Question question = quizService.prepareQuestion();
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
