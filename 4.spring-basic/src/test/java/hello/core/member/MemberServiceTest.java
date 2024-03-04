package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** JUnit 테스트를 사용 */
public class MemberServiceTest {
    MemberService memberService ;

    /**  @BeforeEach` 는 각 테스트를 실행하기 전에 호출된다. */
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given ~~일떄
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 했을떄
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
