package com.dharam.Question.repositories;

import com.dharam.Question.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q FROM Question q Where q.category=:category ORDER BY RANDOM() LIMIT:noOfQ",nativeQuery = false)
    List<Question> findRandomQuestion(@Param("category") String category,@Param("noOfQ") Integer noOfQ);
}
