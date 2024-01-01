package casting;
/* 계산과 형변환
    - 1. 같은 타입까리의 계산은 같은 타입의 결과를 낸다.
        - int + int 는 int를, double+ double은 double의 결과가 나온다.
    - 2. 서로 다른 타입의 계산은 큰 범위로 자동 형변환이 일어난다.
        - int + long 은 long + long으로 자동 형변환이 일어남
        - int + double 은 double + double으로 자동 형변환이 일어남

 */
public class Casting4 {

    public static void main(String[] args) {
        int div1 = 3 / 2;
        System.out.println("div1 = " + div1); //1

        double div2 = 3 / 2;
        System.out.println("div2 = " + div2); //1.0

        double div3 = 3.0 / 2;
        System.out.println("div3 = " + div3); //1.5

        /* 명시적 형변환
            소수점 까지 구하고 싶다면 div4의 예제처럼 명시적 형변환을 사용하면 된다.
         */
        double div4 = (double) 3 / 2;
        System.out.println("div4 = " + div4); //1.5

        int a = 3;
        int b = 2;
        double result = (double) a / b;
        System.out.println("result = " + result); //1.5
    }
}
