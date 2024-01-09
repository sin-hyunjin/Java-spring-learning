package method;

public class Method1 {
/* 두 숫자를 입력 받아서 더하고 출력하는 단순한 기능

    아래 코드를 보면 같은 연산을 두번 실행한다
    만약 여러곳에서 이와 같은 계산은 반복해야 한다면?
 */
    public static void main(String[] args) {
        //계산1
        int a = 1;
        int b = 2;
        System.out.println(a + "+" + b + " 연산 수행");
        int sum1 = a + b;
        System.out.println("결과1 출력: " + sum1);

        //계산2
        int x = 10;
        int y = 20;
        System.out.println(x + "+" + y +" 연산 수행");
        int sum2 = x + y;
        System.out.println("결과2 출력:" + sum2);
    }
}
