package cond;
/* 조건문 else if
    - if문의 조건이 거짓일 떄 다음 조건을 검사한다
    만약 if문이 참이라면 else if문을 실행하지 않는다.

 */
public class If4 {

    public static void main(String[] args) {
        int age  = 15;

        if (age <= 7) {
            System.out.println("미취학");
        } else if (age <= 13) {
            System.out.println("초등학생");
        } else if (age <= 16) {
            System.out.println("중학생");
        } else if (age <= 19) {
            System.out.println("고등학생");
        } else {
            System.out.println("성인");
        }
    }
}
