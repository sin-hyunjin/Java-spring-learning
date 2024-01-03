package springlearning.springwebmvcdb;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springlearning.springwebmvcdb.repository.MemberRepository;
import springlearning.springwebmvcdb.repository.MemoryMemberRepository;
import springlearning.springwebmvcdb.service.MemberService;

@Configurable
public class SpringConfig {

    @Bean // 내가 Bean을 등록한다고 생각하면 된다.
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

