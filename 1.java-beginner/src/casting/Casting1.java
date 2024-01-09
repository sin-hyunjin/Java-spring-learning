package casting;
/* 자동 형변환
    - int에서 double로 값을 대입할때 타입은 다르지만 자동으로 형이 변경된다.
    - 작은 범위 숫자 타입에서 큰 범위 숫자타입으로 자동으로 변경
    - 이런 과정을 자동 형변환, 또는 묵시적 형변환이라 한다.
 */
public class Casting1 {

    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        longValue = intValue; //int -> long
        System.out.println("longValue = " + longValue);

        doubleValue = intValue; //int -> double
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L; //long -> double
        System.out.println("doubleValue2 = " + doubleValue);
    }
}
