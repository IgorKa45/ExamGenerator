package org.skypro.ExamGenerator.service;

import org.skypro.ExamGenerator.question.Question;

import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question removeQuestion(Question question);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();
}
