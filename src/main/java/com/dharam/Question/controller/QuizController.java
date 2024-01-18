package com.dharam.Question.controller;

import com.dharam.Question.entities.Question;
import com.dharam.Question.entities.Quiz;
import com.dharam.Question.entities.QuizQuestion;
import com.dharam.Question.entities.QuizResponse;
import com.dharam.Question.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.QuitResponse;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String title, @RequestParam Integer noOfQ){
        System.out.println(category+" "+title+" "+noOfQ);
        return quizService.createQuiz(category,title,noOfQ);
    }
    //    getQuiz/id
    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuizQuestion>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<QuizResponse> responses){
        return quizService.submitQuiz(id,responses);
    }
}
