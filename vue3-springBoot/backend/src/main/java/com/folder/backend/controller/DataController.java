package com.folder.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Data만 보낼때 사용
public class DataController {

    @GetMapping("/")
    public String home() {
        return "Data 준비 중";
    }
}
