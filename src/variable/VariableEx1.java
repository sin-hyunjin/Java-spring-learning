//- 패키지는 모두 소문자를 사용한다.
package variable;

public class VariableEx1 {

    public static void main(String[] args) {
        int userNum  = 4;
        int comNum = 3;
        int sum = userNum + comNum;
        System.out.println(userNum + comNum);
        System.out.println(userNum * comNum);
        System.out.println(userNum - comNum);
        System.out.println("sum = " + sum);
        
        // soutv시 가까운 변수를 함께출력해줌 
        long longVar = 128312123L;
        System.out.println("longVar = " + longVar);

        boolean booleanVar = true;
        System.out.println("booleanVar = " + booleanVar);
        
        
    }
}
