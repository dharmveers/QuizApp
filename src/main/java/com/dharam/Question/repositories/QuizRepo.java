package com.dharam.Question.repositories;

import com.dharam.Question.entities.Question;
import com.dharam.Question.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
