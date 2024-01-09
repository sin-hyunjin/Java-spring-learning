package scope;

/* 지역변수 (로컬변수)
    - 지역변수 = 특정 지역에서만 딱 사용할수 있는 변수
        - 특정지역이란? 하나의 객체의 지역
     이렇게 변수의 접근 가능한 범위를 스코프(scope)라 한다. scope는 범위라는 뜻
 */
public class Scope1 {

    public static void main(String[] args) {
        int m = 10; //m 생존 시작
        if (true) {
            int x = 20; //x 생존 시작
            System.out.println("if m = " + m);
            System.out.println("if x = " + x);
        } // 조건문이 끝나면 x 생존 종료
        //System.out.println("main x = " + x);
        System.out.println("main m = " + m);
    } //m 생존 종료
}
