package cond;
/* 조건문 if문과 else if문
    - if문에 여러조건이 있다고 항상 if-else로 묶어서 사용할수 있는것은 아님
    - 조건이 서로 영향을 주지 않고 각각 수행해야 하는 경우에는 else if문 보다는 여러 if문을 분리해서 사용해야한다.
 */
public class If5 {

    public static void main(String[] args) {
        int price = 10000;
        int age = 10;
        int discount = 0;

        if (price >= 10000) {
            discount = discount + 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        }

        if (age <= 10) {
            discount = discount + 1000;
            System.out.println("어린이 1000원 할인");
        }

        System.out.println("총 할인 금액: " + discount + "원");
    }
}
