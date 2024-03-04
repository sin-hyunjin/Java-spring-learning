package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/** 정액 할인 정책 구현체
 * 고정으로 1000원 할인이지만 정률 % 할인으로 변경한다면 ??
 * */
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        // enumType은 비교할때 ==를 사용한다.
        if(member.getGrade().equals(Grade.VIP)) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
