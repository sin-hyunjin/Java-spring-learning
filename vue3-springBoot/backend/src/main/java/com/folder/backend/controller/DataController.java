package com.folder.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Data만 보낼때 사용
public class DataController {

    @CrossOrigin(origins = "http://localhost:8800")
    @GetMapping("/")
    public String home() {
        return "Data 준비 중";
    }

    @GetMapping("/api")
    public String api() {
        return "API Data 준비 중";
    }

  
}
