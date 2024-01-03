package springlearning.springwebmvcdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springlearning.springwebmvcdb.service.MemberService;

@Controller // 컨트롤러 애노테이션이 있으면 스프링이 뜰 때 동작을한다.
public class MemberController {

    private  final MemberService memberService;
    // new MemberService()를 등록하기보단 스프링 컨테이너에 등록을 하고 쓰자

    @Autowired // memberService 와연결 시켜줄때 Autowired를 사용
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
