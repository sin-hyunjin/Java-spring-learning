package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


/** AppConfig (구성 영역)
 * 이렇게 의존관계를 연결해주는 것을
 * ioC 컨테이너 DI 컨테이너라 한다
 */
public class AppConfig {
    /** `new MemoryMemberRepository()` 이 부분이 중복 제거되었다. 이제 `MemoryMemberRepository` 를
     다른 구현체로 변경할 때 한 부분만 변경하면 된다.
     `AppConfig` 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르 게 파악할 수 있다.
     */

    /** 생성자 주입 */
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private static MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
