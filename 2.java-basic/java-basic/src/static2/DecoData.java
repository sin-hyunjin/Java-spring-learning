package static2;

/** 클래스 입장에서는 static 값밖에 알수 없다
 * 인스턴스를 알기위해서는 참조값이 필요하다.*/
public class DecoData {

    private int instanceValue; // 인스턴스 변수
    private static int staticValue; // 정적 변수

    /** static만 접근할수 있다 */
    public static void staticCall() {
        // instanceValue++; //인스턴스 변수 접근, compile error
        // instanceMethod(); //인스턴스 메서드 접근, compile error

        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근
    }

    public void instanceCall() {
        instanceValue++; //인스턴스 변수 접근
        instanceMethod(); //인스턴스 메서드 접근

        staticValue++; //정적 변수 접근
        staticMethod(); //정적 메서드 접근
        }



    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
    }

    private static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
        
    }
}
