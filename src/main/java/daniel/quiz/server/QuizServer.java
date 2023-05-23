package daniel.quiz.server;

import daniel.quiz.repository.InMemoryQuestionRepository;

import java.util.NoSuchElementException;

public class QuizServer {

    private Question actualQuestion = null;
    private int correctAnswers = 0;
    private InMemoryQuestionRepository repository;


    public QuizServer(InMemoryQuestionRepository repository) {
        this.repository = repository;

        //przygotowanie bazy pytań
        Question question1 = new Question("Czy jedna klasa może rozszerzać " +
                "wiele interfejsów?", "Tak",
                "Poprawna odpowiedź: można implementować wiele interfejsów a tylko po " +
                        "jednej klasie na raz dziedziczyny");

        Question question2 = new Question("Ile mamy typów prymitywnych?", "8",
                "Poprawna odpowiedź: 8, typy te to: byte, short, int, long," +
                        " float, double, boolean, char");

        repository.add(question1);
        repository.add(question2);
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
}
