package org.skypro.ExamGenerator.controller;

import org.skypro.ExamGenerator.question.Question;
import org.skypro.ExamGenerator.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    //Получить список случайных вопросов
    @GetMapping("/get")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
