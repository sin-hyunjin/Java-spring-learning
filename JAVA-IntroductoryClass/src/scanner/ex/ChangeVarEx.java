package scanner.ex;

public class ChangeVarEx {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp; //a의 값 10

        //시작: 코드를 작성하세요
        temp = a; //10  temp에 a값을 담아줌
        a = b; // a변수에 다시 b값을 담아줌
        b = temp; // b는 temp 값임
        //종료: 코드를 작성하세요

        System.out.println("a = " + a); // 20
        System.out.println("b = " + b); // 10
    }
}