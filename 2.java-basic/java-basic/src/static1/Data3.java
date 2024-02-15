package static1;

/** 기존 코드를 유지하기 위해 새로운 클래스 `Data3` 을 만들었다.
 * `static` 을 붙이게 되면 `static` 변수, 정적 변수 또는 클래스 변수라 한다.*/
public class Data3 {
    public String name;
    public static int count; // 클래스 변수, 정적(static) 변수, static 변수
    // static을 쓰면 힙영역이 아닌 메서드 영역에서 관리가 된다

    public Data3(String name) {
        this.name = name;
        count++; // Data3.count++ 로 안적어도 된다. 같은 클래스 안의 인스턴스 이기떄문에 바로 접근가능하다
    }
}
