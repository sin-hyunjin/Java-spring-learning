package casting;

public class Casting3 {

    public static void main(String[] args) {
        long maxIntValue = 2147483647; //int 최고값
        long maxIntOver = 2147483648L; //int 최고값 + 1을(초과)한 상태
        int intValue = 0;

        intValue = (int) maxIntValue; //형변환
        System.out.println("maxIntValue casting=" + intValue);

        // 기본 범위를 초과해서 표현하게 되면 overflow 문제가 발생한다.
        intValue = (int) maxIntOver; //형변환
        System.out.println("maxIntOver casting=" + intValue); // -2147483648
    }
}
