package daniel.quiz.server;

public class Question {
    private String description;
    private String correctAnswer;
    private String feedback;

    public Question(String description, String correctAnswer, String feedback) {
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.feedback = feedback;
    }

    public String checkAnswer(String answer) {
        String intro = correctAnswer.equalsIgnoreCase(answer) ?
                "Prawidłowa odpowiedź" :
                "Nieprawidłowa odpowiedź";
        return intro + ", " + feedback;
    }


    public String getDescription() {
        return description;
    }
}
