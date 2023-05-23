package daniel.quiz.server;

public class QuizServer {

    private Question question;

    public QuizServer() {
        question = new Question("Czy jedna klasa może rozszerzać " +
                "wiele interfejsów?", "Tak",
                "Poprawna odpowiedź: można implementować wiele interfejsów a tylko po " +
                        "jednej klasie na raz dziedziczyny");

    }

    public Question getQuestion() {
        return question;
    }

    public String checkAnswer(String answer) {
        return question.checkAnswer(answer);
    }


}
