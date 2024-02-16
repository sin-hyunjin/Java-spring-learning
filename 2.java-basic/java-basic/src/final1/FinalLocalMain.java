package final1;


public class FinalLocalMain {
    /** final을 지역변수에 설정할 경우 최초 한번만 할당할 수 있다.
     * 이후에 변수의 값을 변경하려면 컴파일 오류가 발생
     */
    public static void main(String[] args) {
        // final 지역 변수
        final int data1;
        data1 = 10; //최초 한번만 할당 가능
//        data1 = 20; //컴파일 오류

        // final 지역 변수2
        final int data2 = 10;

    }
    static void method(final int parameter) {
//        parameter = 20; // 컴파일 오류
    }
}
