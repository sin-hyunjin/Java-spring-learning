package cond;
/* switch문
    - switch문은 단순히 값이 같은지만 비교할 수 있다.
    - 조건식이 결과 값이 어떤 case의 값과 일치하면 해당 case의 코드를 실핸한다.

 */
public class Switch2 {

    public static void main(String[] args) {
        int grade = 1;

        int coupon;
        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
                coupon = 2000;
                break;
            case 3:
                coupon = 3000;
                break;
            // 조건식의 결과 값이 위의 어떤 값에도 해당하지 않을 떄 실행되는 코드
            default:
                coupon = 500;
        }
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
