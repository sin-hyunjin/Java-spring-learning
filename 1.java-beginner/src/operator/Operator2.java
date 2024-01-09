package operator;

/* 문자열 더하기
    - Java는 String 타입에 다른 더하는 경우 타입을 전부 String으로 바꾼다
 */
public class Operator2 {

    public static void main(String[] args) {
        
        // 문자열과 문자열 더하기 1
        String result1 = "hello " + "world";
        System.out.println("result1 = " + result1); // 출력 : result1 = hello world

        // 문자열과 문자열 더하기 2
        String s1 = "string1";
        String s2 = "string2";
        String result2 = s1 + s2;
        System.out.println("result2 = " + result2); // 출력 : result2 = string1string2
        
        // 문자열과 숫자 더하기 1
        String result3 = "a + b = " + 10;
        System.out.println("result3 = " + result3); // 출력 : result3 = a + b = 10

        // 문자열과 숫자 더하기 2
        int num = 20;
        String str = "a + b = ";
        String result4 = str + num;
        System.out.println("result4 = " + result4); // 출력  result4 = a + b = 20
    }
    
}
