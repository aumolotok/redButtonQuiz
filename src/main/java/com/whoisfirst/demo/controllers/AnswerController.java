package com.whoisfirst.demo.controllers;

import com.whoisfirst.demo.answerManager.AnswerManager;
import com.whoisfirst.dto.AnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@CrossOrigin
public class AnswerController {

    @Autowired
    private AnswerManager answerManager;

    @PostMapping("/readyToAnswer")
    public void readyToAnswer(@RequestBody AnswerDto answerDto)  {
        System.out.println("Get - " + answerDto.toString());
        answerManager.takeAnswer(answerDto);
    }
}
