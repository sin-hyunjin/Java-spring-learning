package cond;
/* 삼항 연산자
    삼항 연산자를 쓰기전 if문으로 썼을떄
 */
public class CondOp1 {

    public static void main(String[] args) {
        int age = 18;
        String status;
        if (age >= 18) {
            status = "성인";
        } else {
            status = "미성년자";
        }
        System.out.println("age = " + age + " status = " + status);
    }
}
