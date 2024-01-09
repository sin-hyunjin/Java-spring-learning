package operator;

public class Operator4 {

    public static void main(String[] args) {
        /* 산술연산자
           - 이렇게 똑같은 결과값이 나오는 문제더라고
           코드가 명학하고 단순한 것이 유지보수 하기 좋으므로 괄호를 고려하기
           - 누구나 코드를 보고 쉽고 명확하게 이해할 수 있어야 한다.
           - 개발에서 가장 중요한 것은 단순함과 명확함이다! 애매하거나 복잡하면 안된다 .

         */
        int sum3 = 2 * 2 + 3 * 3;
        int sum4 = (2 * 2) + (3 * 3);
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);
        
    }
}
