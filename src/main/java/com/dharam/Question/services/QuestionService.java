package com.dharam.Question.services;

import com.dharam.Question.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface QuestionService {
    public ResponseEntity<String> addQuestion(Question question);
    public ResponseEntity<Question> getQuestion(Integer id);
    public ResponseEntity<List<Question>> getAllQuestions();
    public ResponseEntity<List<Question>> getQuestionByCategory(String category);
}
