package casting;

public class Casting2 {

    public static void main(String[] args) {
        double doubleValue = 1.5;
        int intValue = 0;

//        intValue = doubleValue; // 주석풀면 컴파일 오류 발생
//                  ⬇️
        /*java: incompatible types: possible lossy conversion from double to int
            호환되지 않는 유형 : double에서 int로의 가능한 손실 변환
         */

        intValue = (int) doubleValue; // 명시적 형변환 double -> int로 변경하는 형변환
        System.out.println(intValue);
    }
}
