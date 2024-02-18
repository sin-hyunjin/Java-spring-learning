package poly.diamond;

public class DiamondMain {
    public static void main(String[] args) {
        /** 부모는 자식을 담을수 있ㄷ다 */
        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon();

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon();

        Child c = new Child();
        c.methodA();
//        ((InterfaceA)c).methodA();

    }
}
