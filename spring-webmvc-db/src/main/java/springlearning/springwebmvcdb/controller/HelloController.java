package springlearning.springwebmvcdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // web에서 /hello에서 값을 가져옴
    @GetMapping("hello")
    public String hello(Model model) {
        // data = key , hello!! = value
        model.addAttribute("data","hello!!");
        return "hello";
    }
}
