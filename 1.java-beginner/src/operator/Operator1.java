package operator;
    /* 산술연산자

     */
public class Operator1 {

    public static void main(String[] args) {
        // 변수 초기화
        int a = 5;
        int b = 2;

        // 덧셈
        int sum = a + b;
        System.out.println("sum = " + sum);  // 출력 a + b = 7

        // 뺄셈
        int diff = a - b;
        System.out.println("diff = " + diff); // 출력  a - b = 3
        
        // 곱셈
        int multi = a * b;
        System.out.println("multi = " + multi); // 출력 a * b = 10

        // 나눗셉
        int div = a / b; // 5/2 -> 2.5가 나와야함 하지만 출력은 소수점이 제거된 2 가나옴 -> ✏️형변환이 필요하다
        System.out.println("div = " + div); // 출력 a / b = 2
        
        // 나머지
        int mod = a % b;
        System.out.println("mod = " + mod); // 출력 a % b = 1


    }
}


