package daniel.quiz.server;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    private  int id;
    private static  int nextNumber = 1;
    private  String description;
    @Column(name = "correct_answer")
    private  String correctAnswer;
    private  String feedback;

    public Question(String description, String correctAnswer, String feedback) {
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.feedback = feedback;
        //reczna implementacja generowania id
        id = nextNumber++;
        //nextNumber++;
    }

    public Question() {
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

    public int getId() {
        return id;
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
