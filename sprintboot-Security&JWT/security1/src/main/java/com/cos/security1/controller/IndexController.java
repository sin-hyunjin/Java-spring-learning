package com.cos.security1.controller;

import com.cos.security1.auth.PrincipalDetails;
import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // View를 return
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/test/login")
    public @ResponseBody String testLogin(Authentication authentication,  // DI(의존성 주입)
                                          @AuthenticationPrincipal PrincipalDetails userDetails ) { // 세션 접근가능
        System.out.println("/test/login ========================= ");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication = " + principalDetails.getUser());
        System.out.println("userDetails = " + userDetails.getUser());
        return "세션 정보 확인하기";
    }

    @GetMapping("/test/oauth/login")
    public @ResponseBody String testOAuthLogin(Authentication authentication, // DI(의존성 주입)
                                        @AuthenticationPrincipal OAuth2User oauth) { // 세션 접근가능
        System.out.println("/test/oauth/login ========================= ");
        // 다운 캐스팅
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication = " + oAuth2User.getAttributes());
        System.out.println("oauth.getAttributes() = " + oauth.getAttributes());
        return " OAuth 세션 정보 확인하기";
    }

    @GetMapping({"","/"}) // { localhost:8080/ ,  Localhost:8080 }
    public String index() {
        // jpa가 아닌 Mustach를 이용
        // 머스테치 기본폴더 src/main/resources/
        // 뷰리졸버 설정 : templates(prefix), .mustache(sufiix)생략가능
        return "index"; //
    }

    // OAuth 로그인을 해도 PrincipalDetails 받아짐
    @GetMapping("/user")
    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails.getUser() = " + principalDetails.getUser());
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
    public String join(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setRole("ROLE_USER");
        user.setPassword(password);
        userRepository.save(user);  // 회원가입은 잘됨  비밀번호:1234 그대로 노출 -> 시큐리티로 로그인을 할수 없음 -> 패스워드가 암호화가 되어있지않기 때문
        System.out.println(user);
        return "redirect:/loginForm"; // redirect:/ = 다음 함수를 호출해준다
    }

    @Secured("ROLE_ADMIN") // SecurityConfig에서 Global로 걸어도 되지만 특정 한개의 함수를 ROLE_ADMIN만 접근가능하게 설정하고싶다면 적용
    @GetMapping("/info")
    public @ResponseBody String info() {
        return "개인정보";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") // 여러개의 접근권한을 설정하고 싶다면
    @GetMapping("/data")
    public @ResponseBody String data() {
        return "데이터 정보";
    }
}
