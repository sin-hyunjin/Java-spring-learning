package cond;
/* switch문
    - switch문은 단순히 값이 같은지만 비교할 수 있다.
    - 조건식이 결과 값이 어떤 case의 값과 일치하면 해당 case의 코드를 실핸한다.

 */
public class Switch3 {

    public static void main(String[] args) {
        int grade = 1;

        int coupon;
        switch (2) {
            case 1:
                coupon = 1000;
                break;
            // case2, 3이 같은 결과값일 떄 break문 이 없다면 3까지 실행됨
            case 2:
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
