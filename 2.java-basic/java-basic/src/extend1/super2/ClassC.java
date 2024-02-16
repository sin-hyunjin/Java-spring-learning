package extend1.super2;

public class ClassC extends ClassB{

    /** 부모 클래스에 생성자가 있으면 super로 직접 정의해줘야한다 */
    public ClassC() {
        super(10, 20);
        System.out.println("ClassC 생성자");
    }
}
