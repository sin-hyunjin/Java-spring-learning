package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    /** 단일 테스트가 중요하다. 스프링 도움 없이 순수한 자바코드로 테스트 해보는것 */
    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //then
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //when
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
