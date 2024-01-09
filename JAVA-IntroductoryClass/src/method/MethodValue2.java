package method;

public class MethodValue2 {
        /* 서로 다른 메서드
        main과 changeNumber은 서로 관계가 없는 mothod이다.
         */

    // main method
    public static void main(String[] args) {
        int number = 5;
        System.out.println("1. changeNumber 호출 전, number: " + number); //5
        changeNumber(number);
        System.out.println("4. changeNumber 호출 후, number: " + number); //5
    }
    // changeNumber method
    public static void changeNumber(int number) { //number도 지역변수이다
        System.out.println("2. changeNumber 변경 전, number: " + number); //5
        number = number * 2;
        System.out.println("3. changeNumber 변경 후, number: " + number); //10
    }
}
