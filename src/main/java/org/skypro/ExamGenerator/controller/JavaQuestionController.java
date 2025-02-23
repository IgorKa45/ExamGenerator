package org.skypro.ExamGenerator.controller;

import org.skypro.ExamGenerator.question.Question;
import org.skypro.ExamGenerator.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService service;



    public JavaQuestionController(QuestionService service) {
        this.service = service;

    }

    //Добавить вопрос
    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question,@RequestParam String answer) {
        return service.addQuestion(question, answer);
    }
    //Удалить вопрос
    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer) {
        return service.removeQuestion(new Question(question, answer));
    }
    //Получить все вопросы
    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return service.getAllQuestions();
    }
}
