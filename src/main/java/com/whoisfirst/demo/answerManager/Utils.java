package com.whoisfirst.demo.answerManager;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class Utils {

    public static  <T> ResponseEntity<T> getDefault(T body){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin",
                "true");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(body);
    }
}
