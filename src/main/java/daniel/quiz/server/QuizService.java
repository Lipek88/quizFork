package daniel.quiz.server;

import daniel.quiz.repository.InMemoryQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service//czy dałbym radę uniknąć używania springowych rzeczy?
public class QuizService {

    private Question actualQuestion = null;
    private int correctAnswers = 0;
    private InMemoryQuestionRepository repository;


    public QuizService(InMemoryQuestionRepository repository) {
        this.repository = repository;
    }

    public List<String> getIntroText() {
        List<String> messages = new ArrayList<>();
        messages.add("Rozpoczynasz quiz z javy!");
        messages.add("Quiz ma na celu pomóc Ci przećwiczyć swoje odpowiedzi na pytania z najważniejszych dziedzin" +
                "programowania w javie."
        );
        messages.add("Po każdym pytaniu zobaczysz poprawną odpowiedź");
        return messages;
    }

    public Question prepareQuestion() { //rzuca wyjątek jak się skończą
        setNextQuestion();
        return actualQuestion;
    }

    public void setNextQuestion() {
        int questionNumber = 1;
        if (actualQuestion != null) {
            questionNumber = actualQuestion.getNumber() + 1;
        }
        actualQuestion = repository.findQuestionBy(questionNumber)
                .orElseThrow(() -> new NoSuchElementException("Nie znaleziono pytania"));
    }


    public String userAnswered(String answer) {
        Question.AnswerResult answerResult = actualQuestion.checkAnswer(answer);
        if (answerResult.isCorrect()) {
            correctAnswers++;
        }
        return answerResult.getFeedback();
    }


    public int howManyCorrect() {
        return correctAnswers;
    }

    Question getActualQuestion() {
        return actualQuestion;
    }
}
