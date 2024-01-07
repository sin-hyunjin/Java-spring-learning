package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // View를 리턴 하겠다
public class InderController {

    // localhost:8080
    @GetMapping({"","/"})
    public String index() {
        // jpa가 아닌 Mustach를 이용
        // 머스테치 기본폴더 src/main/resources/
        // 뷰리졸버 설정 : templates(prefix), .mustache(sufiix)생략가능
        return "index"; //
    }
}
