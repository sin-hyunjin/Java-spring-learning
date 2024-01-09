package scope;
/* scope의 존재이유

 */
public class Scope3_1 {
    public static void main(String[] args) {
        /* 조건이 맞으면 변수 m의 값을 2배 증가하는 간략한 코드
        하지만 좋은 코드는 아님

        - 비효율적인 메모리 사용: temp는 if코드 블록에서만 필요함,
          하지만 지금 코드는 main()코드 블록이 종료될 떄 까지 메모리에 유지된다.

        - 코드 복잡성 증가 : 좋은 코드는 군더더기 없는 단순한 코드
          이코드를 유지 보수할 때 m은 물론이고 temp까지 계속 신경써야 한다.
         */
        int m = 10;
        int temp = 0;
        if (m > 0) {
            temp = m * 2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
