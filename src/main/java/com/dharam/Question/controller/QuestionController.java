package com.dharam.Question.controller;

import com.dharam.Question.entities.Question;
import com.dharam.Question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService service;
    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return this.service.getAllQuestions();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Integer id){
        return this.service.getQuestion(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
//        Question ques = this.service.addQuestion(question);
        return this.service.addQuestion(question);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return  this.service.getQuestionByCategory(category);
    }
}