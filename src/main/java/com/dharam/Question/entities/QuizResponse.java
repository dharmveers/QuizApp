package com.dharam.Question.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuizResponse {
    private Integer id;
    private String ans;
}
