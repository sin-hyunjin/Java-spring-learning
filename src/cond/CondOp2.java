package cond;
/* 삼항 연산자
    - 항이 3개인 연산자 간결한 코드를 작성 가능
    - (조건) ? true : false
 */
public class CondOp2 {

    public static void main(String[] args) {
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println("age = " + age + " status = " + status);
    }
}
