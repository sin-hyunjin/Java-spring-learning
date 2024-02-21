package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/** JUnit 테스트를 사용 */
public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
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
