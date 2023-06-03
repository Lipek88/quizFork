package daniel.quiz.server;

import daniel.quiz.repository.InMemoryQuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    @Test
    @DisplayName("setNextQuestion asks repository for question of correct number.")
    public void test1() {
        //given
        Question question1 = new Question("Czy jedna klasa może rozszerzać " +
                "wiele interfejsów?", "Tak",
                "Poprawna odpowiedź: można implementować wiele interfejsów a tylko po " +
                        "jednej klasie na raz dziedziczyny");

        Question question2 = new Question("Ile mamy typów prymitywnych?", "8",
                "Poprawna odpowiedź: 8, typy te to: byte, short, int, long," +
                        " float, double, boolean, char");

        //InMemoryQuestionRepository repository = new InMemoryQuestionRepository();
        InMemoryQuestionRepository mock = Mockito.mock(InMemoryQuestionRepository.class);
        Mockito.when(mock.findQuestionBy(1)).thenReturn(Optional.of(question1));
        Mockito.when(mock.findQuestionBy(2)).thenReturn(Optional.of(question2));


        QuizService quizService = new QuizService(mock);



        quizService.setNextQuestion();
        assertEquals(question1, quizService.getActualQuestion());
        quizService.setNextQuestion();
        Mockito.verify(mock).findQuestionBy(1);
        assertEquals(question2, quizService.getActualQuestion());
        Mockito.verify(mock).findQuestionBy(2);



    }


}
