package com.whoisfirst.dto;

import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class AnswerDto implements Comparable<AnswerDto> {
    public String name;
    public String time;

    public static AnswerDto emptyDto() {
        var result = new AnswerDto();
        result.name = "Empty";
        result.time = null;
        return result;
    }

    @Override
    @SneakyThrows
    public int compareTo(AnswerDto answerDto) {
        String PATTERN_WITH_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        DateFormat dateFormat = new SimpleDateFormat(PATTERN_WITH_MILLIS);

        Date current = dateFormat.parse(time);
        Date other = dateFormat.parse(answerDto.time);
        return current.compareTo(other);
    }
}



