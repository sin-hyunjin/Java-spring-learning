package springlearning.springwebmvcdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Home Controller 추가
 *
 */
@Controller
public class HomeController {

    //참고: 컨트롤러가 정적 파일보다 우선순위가 높다.
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
