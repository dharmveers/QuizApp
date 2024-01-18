package com.dharam.Question.services;

import com.dharam.Question.entities.Question;
import com.dharam.Question.entities.QuizQuestion;
import com.dharam.Question.entities.QuizResponse;
import org.springframework.http.ResponseEntity;

import java.awt.desktop.QuitResponse;
import java.util.List;

public interface QuizService {
    ResponseEntity<String> createQuiz(String category, String title, Integer noOfQ);

    ResponseEntity<List<QuizQuestion>> getQuizById(Integer id);

    ResponseEntity<Integer> submitQuiz(Integer id, List<QuizResponse> responses);
}
