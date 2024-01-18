package com.dharam.Question.services.Impl;

import com.dharam.Question.entities.Question;
import com.dharam.Question.repositories.QuestionRepo;
import com.dharam.Question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public ResponseEntity<String> addQuestion(Question question) {
        return new ResponseEntity<>("Question is saved Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Question> getQuestion(Integer id) {
        return new ResponseEntity<>(this.questionRepo.findById(id).orElseThrow(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(this.questionRepo.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
//        return this.questionRepo.findAll().stream()
//                                            .filter(question -> question.getCategory()
//                                            .equalsIgnoreCase(category)).toList();
        return new ResponseEntity<>(this.questionRepo.findByCategory(category),HttpStatus.OK);
    }
}
