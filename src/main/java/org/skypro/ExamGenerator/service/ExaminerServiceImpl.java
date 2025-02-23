package org.skypro.ExamGenerator.service;

import org.skypro.ExamGenerator.question.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public  Collection<Question> getQuestions (int amount) {
        Collection<Question> allQuestions = questionService.getAllQuestions();
        if (amount > allQuestions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрошено больше вопросов, чем доступно.");
        }
        Set<Question> selectedQuestions = new HashSet<>();
        while (selectedQuestions.size() < amount) {
            selectedQuestions.add(questionService.getRandomQuestion());
        }
        return selectedQuestions;
    }

}
