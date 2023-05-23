package daniel.quiz;

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
        return modelAndView;
    }



}
