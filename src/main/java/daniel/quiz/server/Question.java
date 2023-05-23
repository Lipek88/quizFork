package daniel.quiz.server;

public class Question {
    private final int number;
    private static  int nextNumber = 1;
    private final String description;
    private final String correctAnswer;
    private final String feedback;

    public Question(String description, String correctAnswer, String feedback) {
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.feedback = feedback;
        //reczna implementacja generowania id
        number = nextNumber++;
        //nextNumber++;

    }

    public String checkAnswer(String answer) {
        //tenary operator, skrócony if dla przypadku w którym mamy jedne dane dla
        //spełnionego warunku inne dla nieprawdy
        String intro = correctAnswer.equalsIgnoreCase(answer) ?
                "Prawidłowa odpowiedź" :
                "Nieprawidłowa odpowiedź";
        return intro + ", " + feedback;
    }


    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }

}
