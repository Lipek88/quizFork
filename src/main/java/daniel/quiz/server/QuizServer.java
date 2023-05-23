package daniel.quiz.server;

import daniel.quiz.repository.InMemoryQuestionRepository;

import java.util.NoSuchElementException;

public class QuizServer {

    private Question actualQuestion = null;
    private int correctAnswers = 0;
    private InMemoryQuestionRepository repository;


    public QuizServer(InMemoryQuestionRepository repository) {
        this.repository = repository;
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
