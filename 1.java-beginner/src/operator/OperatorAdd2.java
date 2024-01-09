package operator;
/* 전위 증감 연산자, 후위 증감 연산자

 */
public class OperatorAdd2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        b = ++a; // a의 값을 먼저 증가 시키고, 그 결과를 b에 대입
        System.out.println("a = " + a + ", b = " + b); // 결과 : a = 2, b = 2

        // 후위 증감 연산자 사용 예
        a = 1; // a값을 다시 1로 지정
        b = 0; // b값을 다시 0으로 지정

        b = a++;
        System.out.println("a = " + a + ", b = " + b); // 결과 : a = 2, b = 1

    }
}
