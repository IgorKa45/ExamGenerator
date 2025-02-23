package org.skypro.ExamGenerator.service;

import org.skypro.ExamGenerator.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
