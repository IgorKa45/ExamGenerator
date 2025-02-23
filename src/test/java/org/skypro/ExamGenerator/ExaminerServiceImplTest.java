package org.skypro.ExamGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.ExamGenerator.question.Question;
import org.skypro.ExamGenerator.service.ExaminerServiceImpl;
import org.skypro.ExamGenerator.service.QuestionService;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetQuestionsSuccess() {
        when(questionService.getAllQuestions()).thenReturn(Set.of(
                        new Question("Определение ромба.", "Это параллелограмм, противоположные углы которого равны."),
                        new Question("Определение прямоугольника.", "Это параллелограмм, у которого все углы прямые."),
                        new Question("Определение параллелограмма.", "Это четырёхугольник, у которого противоположные стороны попарно параллельны и равны.")
                ));
        when(questionService.getRandomQuestion())
                .thenReturn(new Question("Определение ромба.", "Это параллелограмм, противоположные углы которого равны."));
        var questions = examinerService.getQuestions(1);
    }

    @Test
    void testGetQuestionsMoreThanAvailable() {
        when(questionService.getAllQuestions()).thenReturn(Set.of(
                new Question("Определение ромба.", "Это параллелограмм, противоположные углы которого равны.")
        ));
        assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(2));
    }
}
