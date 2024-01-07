package com.cos.security1.controller;

import com.cos.security1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    // localhost:8080
    @GetMapping({"","/"})
    public String index() {
        // jpa가 아닌 Mustach를 이용
        // 머스테치 기본폴더 src/main/resources/
        // 뷰리졸버 설정 : templates(prefix), .mustache(sufiix)생략가능
        return "index"; //
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }
    @PostMapping("/join")
    // mddel/User에 있는 값을 가져옴
    public @ResponseBody String join(User user) {
        System.out.println(user);
        return "join";
    }

}
