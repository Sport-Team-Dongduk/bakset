package com.mysite.basketproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.List;

import com.mysite.basketproject.answer.Answer;
import com.mysite.basketproject.question.Question;
import com.mysite.basketproject.question.QuestionRepository;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mysite.basketproject.question.QuestionService;
@SpringBootTest
class BasketprojectApplicationTests {

    @Autowired
    private QuestionService questionService;
    @Transactional
    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }

}