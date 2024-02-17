package poly.basic;


/** 다운캐스팅을 자동으로 하지 않는 이유
 * 다운캐스팅은 잘못하면 심각한 런타임 오류가 발생할 수 있다. */
public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1; // 캐스팅을 해줘야 문제가 없음
        child1.childMethod(); // 실행 문제 없음

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; // 런타입 오류 - ClassCastException -> 인스턴스가 없기 때문
        child2.childMethod(); // 실행 안됨
    }

}
