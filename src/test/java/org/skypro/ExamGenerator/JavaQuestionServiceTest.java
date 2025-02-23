package org.skypro.ExamGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.skypro.ExamGenerator.question.Question;
import org.skypro.ExamGenerator.service.JavaQuestionService;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddQuestion() {
        Question question = javaQuestionService.addQuestion("Определение угла", "Геометрическая фигура, которая состоит из точки и двух лучей, исходящих из этой точки");
        assertNotNull(question);
        assertEquals(1, javaQuestionService.getAllQuestions().size());
    }
    @Test
    void testRemoveQuestion() {
        Question question = javaQuestionService.addQuestion("Определение угла", "Геометрическая фигура, которая состоит из точки и двух лучей, исходящих из этой точки");
        javaQuestionService.removeQuestion(question);
        assertEquals(0,javaQuestionService.getAllQuestions().size());
    }
    @Test
    void testGetRandomQuestion() {
        javaQuestionService.addQuestion("Определение угла", "Геометрическая фигура, которая состоит из точки и двух лучей, исходящих из этой точки");
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
    }
}
