package method;

public class MethodValue0 {
    /*대원칙
    자바는 항상 변수의 값을 복사해서 대입한다 .
     */
    public static void main(String[] args) {
        int num1 = 5;  // num1의 값은 5
        int num2 = num1; // num2 변수에 대입하기전에 , num1의 값 5를 읽음  결과 num1(5), num2(5)
        num2 = 10;  // num2에 10을 대입

        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);
    }
}
