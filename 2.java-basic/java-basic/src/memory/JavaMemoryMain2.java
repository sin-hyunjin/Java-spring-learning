package memory;

public class JavaMemoryMain2 {

    /**
     * `main()` `method1()` `method2()` 순서로 호출하는 단순한 코드이다.
     * method1()` 에서 `Data` 클래스의 인스턴스를 생성한다
     * method1()` 에서 `method2()` 를 호출할 때 매개변수에 `Data` 인스턴스의 참조값을 전달한다.
     */
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");
    }

    /** `method1()` 은 `method2()` 를 호출하면서 `Data data2` 매개변수에 `x001` 참조값을 넘긴다.*/
    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10); // 객체 인스턴스는 힙 영역에 관리된다.
        method2(data1);
        System.out.println("method1 end");
    }

    /** 이제 `method1()` 에 있는 `data1` 과 `method2()` 에 있는 `data2` 지역 변수(매개변수 포함)는 둘다 같은 `x001` 인스턴스를 참조한다.*/
    static void method2(Data data2) {
        System.out.println("method2 start");
        System.out.println("data.value = " + data2.getValue());
        System.out.println("method2 end");
    }

    /** 정리
     * 지역 변수는 스택 영역에, 객체(인스턴스)는 힙 영역에 관리되는 것을 확인했다.
     * 이제 나머지 하나가 남았다. 바로 메서 드 영역이다.
     * 메서드 영역이 관리하는 변수도 있다.
     * 이것을 이해하기 위해서는 먼저 `static` 키워드를 알아야 한다.
     * `static` 키워드는 메서드 영역과 밀접한 연관이 있다.
     */
}
