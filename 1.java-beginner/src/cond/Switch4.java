package cond;
/* switch문
   자바 14 새로운 switch문
 */
public class Switch4 {

    public static void main(String[] args) {
        int grade = 2;
        // 자바 14이상에서 화살표로 switch로 쓸수 있다.
        // 선택된 데이터를 반환할수 있다.
        int coupon = switch (grade) {
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default ->  500;
        };
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
