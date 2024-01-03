package springlearning.springwebmvcdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // web에서 /hello에서 값을 가져옴
    @GetMapping("hello")
    public String hello(Model model) {
        // data = key , hello!! = value
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //https 에서 이데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; //hello spring
    }

//    json 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // HelloController.Hello 라고 할수 있음 자바에서 정식으로 지원하는 문법
    static class Hello {
        /* cmd + n
        - get + set = java bin 표준 방식
         */
        private String name;

        // 꺼낼 떄
        public String getName() {
            return name;
        }
        // 넣을 떄
        public void setName(String name) {
            this.name = name;
        }
    }
}
