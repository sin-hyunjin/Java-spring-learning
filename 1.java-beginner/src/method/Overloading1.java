package method;
/* method overloading
    - 두 수를 더하는 메서드
    - 세 수를 더하는 메서드
    이경우 둘다 더하는 메서드이기 떄문에 가급적 같은 이름인 add를 사용하고 싶음
    자바는 메서드의 이름 뿐만 아니라 매개변서 정보를 함계 사용하서 메서드를 구분한다.
    따라서 이름이 같고, 매개변수가 다른 매서드를 정의 할수 있다,

    오버로딩 규칙
    - 메서드의 이름이 같아도 매개변수의 타입 및 순서가 다르면 오버로등을 할 수 있다. 참고로 반환 타입은 인정하지 않음

 */
public class Overloading1 {

    public static void main(String[] args) {
        System.out.println("1: " + add(1,2));
        System.out.println("2: " + add(1,2,3));
    }

    public static int add(int a, int b) {
        System.out.println("1번 호출");
        return a + b;
    }

    public static int add(int a, int b, int c) {
        System.out.println("2번 호출");
        return a + b + c;
    }
}
