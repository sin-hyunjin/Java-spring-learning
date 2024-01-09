package variable;
/* 리터럴
    - 코드에서 개발자가 직접 입력한 고정된 값이다.
 */
public class Var7 {
    public static void main(String[] args) {
        int a = 100; //정수
        double b = 10.5; //실수
        boolean c = true; // 불리언(boolean) true, false 입력 가능
        char d = 'A'; // 문자 하나를 다룰 떄 사용, '작은따옴표' 사용
        String e = "Hello Java"; // 문자열, 문자열을 다루기 위한 특별한 타입 (나중에 클래스할떄 더배움)

        // cmd + d 로 복사붙여넣기 한번에가능 (피가되고 살이되는 단축키)
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
