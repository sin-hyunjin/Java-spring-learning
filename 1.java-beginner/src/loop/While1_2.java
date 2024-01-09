package loop;
/* while문
    - while(조건식) {
        // 코드
      }
 */
public class While1_2 {

    public static void main(String[] args) {
        int count = 0;

        while (count < 3) {
            count = count + 1;
            System.out.println("현재 숫자는:" + count);
        }
    }

}
