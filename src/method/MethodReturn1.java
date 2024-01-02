package method;
/* 반환타입 boolean
    return 문을 만나면 메서드를 바로 빠져나간다.
 */
public class MethodReturn1 {

    public static void main(String[] args) {
        boolean result = odd(2);
        System.out.println(result);
    }

    public static boolean odd(int i) {
        if (i % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
