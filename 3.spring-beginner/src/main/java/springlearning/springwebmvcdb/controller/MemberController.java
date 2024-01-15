package springlearning.springwebmvcdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springlearning.springwebmvcdb.domain.Member;
import springlearning.springwebmvcdb.service.MemberService;

import java.sql.SQLException;
import java.util.List;

@Controller // 컨트롤러 애노테이션이 있으면 스프링이 뜰 때 동작을한다.
public class MemberController {

    private  final MemberService memberService;
    // new MemberService()를 등록하기보단 스프링 컨테이너에 등록을 하고 쓰자

    @Autowired // memberService 와연결 시켜줄때 Autowired를 사용
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입 버튼 클릭시 /members/new 로 들어가짐 이런 방식을 get방식이라고 함
    // 기본적으로 url창에 엔터치는 방식은 getmapping이다

    @GetMapping(value = "/members/new")
    public String creatForm() {
        // template에서 members/createMemberForm.html 찾음
        // 폼에 데이터를 넣어서 전달할 때 post를 쓰고, get은 조회할 떄 주로 쓴다.
        return "members/createMemberForm";
    }



    @PostMapping("/members/new")
    // 2. 회원가입 데이터가 들어올 곳
    public String create(MemberForm form) throws SQLException { //MemberForm에서 name값을 찾아옴
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    /* 회원 조희

     */
    @GetMapping("/members")
    // Model은 스프링 프레임워크임
    public String list(Model model){
        /* option + cmd + v 하면 자동생성 
         memberService.findMembers();
         */
        List<Member> members = memberService.findMembers();
        // key값으로 members를 받아옴
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
