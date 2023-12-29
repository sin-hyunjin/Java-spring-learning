package operator;
/* 문자열 비교
    - 문자열 비교는 .equals로 비교한다
    - cmd + shift + enter를 하면 자동으로 세미콜론 생성해준다
 */
public class Comp2 {

    public static void main(String[] args) {
        String str1 = "문자열1";
        String str2 = "문자열2";

        boolean result1 = "hello".equals("hello"); //리터럴 비교
        boolean result2 = str1.equals("문자열1"); //문자열 변수, 리터럴 비교
        boolean result3 = str1.equals(str2); //문자열 변수 비교

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
