package com.dharam.Question.services.Impl;

import com.dharam.Question.entities.Question;
import com.dharam.Question.entities.Quiz;
import com.dharam.Question.entities.QuizQuestion;
import com.dharam.Question.entities.QuizResponse;
import com.dharam.Question.repositories.QuestionRepo;
import com.dharam.Question.repositories.QuizRepo;
import com.dharam.Question.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.desktop.QuitResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public ResponseEntity<String> createQuiz(String category, String title, Integer noOfQ) {
       List<Question> questions = questionRepo.findRandomQuestion(category,noOfQ);
       Quiz quiz=new Quiz();
       quiz.setTitle(title);
       quiz.setQuestions(questions);
       quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz created Successfully..", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuizQuestion>> getQuizById(Integer id) {
        List<Question> questions = quizRepo.findById(id).orElseThrow().getQuestions();
        List<QuizQuestion> quizQuestion = questions.stream().map(question -> {
            return new QuizQuestion(
                    question.getId(),
                    question.getQuestionTitle(),
                    question.getOption1(),
                    question.getOption2(),
                    question.getOption3(),
                    question.getOption4()
            );
        }).collect(Collectors.toList());
        return new ResponseEntity<>(quizQuestion,HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Integer> submitQuiz(Integer id, List<QuizResponse> responses) {
        List<Question> questions = quizRepo.findById(id).orElseThrow().getQuestions();
        int i=0,count=0;
        for(QuizResponse response:responses){
            if(response.getAns().equalsIgnoreCase(questions.get(i).getRightAnswer())){
                count++;
            }
            i++;
        }
        return new ResponseEntity<>(count,HttpStatus.ACCEPTED);
    }
}
