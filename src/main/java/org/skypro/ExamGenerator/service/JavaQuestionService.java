package org.skypro.ExamGenerator.service;

import org.skypro.ExamGenerator.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    public JavaQuestionService(Set<Question> questions) {
        this.questions = (questions != null) ? questions : new HashSet<>();
    }

    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question removeQuestion(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }
    @Override
    public Collection<Question> getAllQuestions(){
        return  Collections.unmodifiableSet(questions);
    }
    @Override
    public Question getRandomQuestion(){
        if (questions.isEmpty()) {
            return null;
        }
        int index = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}
