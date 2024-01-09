package cond;
/* 조건문 else if문

 */
public class If3 {

    /* 코드 분석
        - 이코드는 조건을 만족해도 불필요한 다음 조건을 계속 검사함
        결과는 중학생이지만 나머지 if문을 통한 조건 검사도 모두 실행함.
        - 결과적으로 조건을 중복체크하기 때문에 if4.java 파일에서 else if문으로 코드의 효율성을 향상 시킬수 있음
     */
    public static void main(String[] args) {
        int age = 14;

        if (age <= 7) {
            System.out.println("미취학");
        }
        if (age >= 8 && age <= 13) {
            System.out.println("초등학생");
        }
        if (age >= 14 && age <= 16) {
            System.out.println("중학생");
        }
        if (age >= 17 && age <= 19) {
            System.out.println("고등학생");
        }
        if (age >= 20) {
            System.out.println("성인");
        }
    }
}
