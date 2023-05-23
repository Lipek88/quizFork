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

    public AnswerResult checkAnswer(String answer) {
        //tenary operator, skrócony if dla przypadku w którym mamy jedne dane dla
        //spełnionego warunku inne dla nieprawdy
        boolean correct = correctAnswer.equalsIgnoreCase(answer);
        String intro = correct ?
                "Prawidłowa odpowiedź" :
                "Nieprawidłowa odpowiedź";
        String fullFeedback = intro + ", " + feedback;

        return new AnswerResult(fullFeedback,correct);
    }


    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }

    public static class AnswerResult{

        private String feedback;
        private boolean correct;

        public AnswerResult(String feedback, boolean correct) {
            this.feedback = feedback;
            this.correct = correct;
        }

        public String getFeedback() {
            return feedback;
        }

        public boolean isCorrect() {
            return correct;
        }
    }

}
