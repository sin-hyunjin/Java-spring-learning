package method;
/* 자바에서는 함수를 메서드라고 한다
    - 제어자(Modifier) : public, static과 같은 부분
    - 반환타입(Return type): 메서드가 실행 된 후 반환하는 데이터의 타입을 지정한다. 메서드가 값을 반환하지 않은 경우,
    없다는 뜻의 void를 사용해야한다.
    - 메서드이름(Method Name): 메시더의 이름이다. 이 이름은 메서드를 호출하는 데 사용된다.
    - 매개변수(Parameter): 입력 값으로, 메서드 내부에서 사용할 수 있는 변수이다.
    - 메서든 본문(Method Body): 실제 메서드의 코드가 위치한다. 중괄호 {} 사이에 코드를 작성

 */
public class Method1Ref {

    public static void main(String[] args) {
        //계산1
        int sum1 = add(5, 10);
        System.out.println("결과1 출력: " + sum1);

        //계산2
        int sum2 = add(15, 20);
        System.out.println("결과2 출력:" + sum2);
    }

    //add 메서드
    public static int add(int a, int b) {
        System.out.println(a + "+" + b + " 연산 수행");
        int sum = a + b;
        return sum; // 결과값을 반환
    }
}
