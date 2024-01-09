package cond;
/* 조건문 if, else
    조건이 true 라면 조건문을 바로 나오고
    조건이 false 라면 다음 조건문으로 넘어간다.
 */
public class If1 {

    public static void main(String[] args) {
        int age = 20; //사용자 나이

        // age값은 20이므로 true
        if (age >= 18) {
            System.out.println("성인입니다.");
        }
        if (age < 18) {
            System.out.println("미성년자입니다.");
        }
    }
}
