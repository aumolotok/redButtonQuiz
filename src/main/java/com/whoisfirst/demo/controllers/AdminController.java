package com.whoisfirst.demo.controllers;

import com.whoisfirst.demo.answerManager.AnswerManager;
import com.whoisfirst.demo.answerManager.Utils;
import com.whoisfirst.dto.AnswerDto;
import com.whoisfirst.dto.StatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AnswerManager answerManager;

    @GetMapping("/openQuestion")
    void openQuestion() {
        answerManager.readyToTakeAnswer = true;

    }

    @GetMapping("/closeQuestion")
    void closeQuestion() {
        answerManager.readyToTakeAnswer = false;
    }

    @GetMapping("/clearQueue")
    void clearQueue() {
        answerManager.clearAnswers();
    }

    @GetMapping("/isQuestionOpen")
    ResponseEntity<StatusDto> isQuestionOpen() {
        return ResponseEntity
                .ok()
                .body(new StatusDto(answerManager.readyToTakeAnswer));
    }

    @GetMapping("/listOfAnswers")
    List<AnswerDto> listOfAnswers() {

        return answerManager.getFirstFive();
    }



}
