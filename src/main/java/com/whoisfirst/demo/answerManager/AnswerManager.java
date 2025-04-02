package com.whoisfirst.demo.answerManager;

import com.whoisfirst.dto.AnswerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerManager {

    private static List<AnswerDto>  answers = new ArrayList<>();

    public boolean readyToTakeAnswer = true;

    public void takeAnswer(AnswerDto answerDto) {
        answers.add(answerDto);
    }

    public void clearAnswers() {
        answers = new ArrayList<>();
    }

    public AnswerDto getFirstAnswer() {
        if(answers.get(0) == null ) {
            return AnswerDto.emptyDto();
        }
        return answers.get(0);
    }

    public List<AnswerDto> getFirstFive() {
        return answers.stream().sorted(AnswerDto::compareTo).toList();
    }


}
