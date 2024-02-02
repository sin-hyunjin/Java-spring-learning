package ref;

/** 데이터 초기화
 *

 */
public class InitMain {
    public static void main(String[] args) {
        // value1 은 초기값을 지정하지 않았지만 멤버 변수는 자동으로 초기화 된다. 숫자는 0 으로 초기화된다
        // value2 는 10 으로 초기값을 지정해두었기 때문에 객체를 생성할 때 10 으로 초기화된다
        InitData data = new InitData();
        System.out.println(" value1 " + data.value1 );
        System.out.println(" value1 " + data.value2 );
    }
}

