package loop;
/* break, continue
    - while, do-while, for 와같은 모든 반복문에서 사용 가능
    - break : 반복문을 즉시 종료하고 나간다.
    - continue : 반복문의 나머지 부분을 건너뛰고 다음 반복을 진행하는데 사용된다,
 */
public class Break1 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        while(true) {
            sum = sum + i;
            if (sum > 10) {
                System.out.println("합이 10보다 크면 종료: i=" + i + " sum=" + sum);
                break;
            }
            i++;
        }
    }
}
