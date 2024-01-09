package variable;

public class Var8 {

    public static void main(String[] args) {
        // 정수 (높을수록 메모리를 많이 차지한다)
        byte b = 127; //-128 ~ 127 까지 사용 가능
        short s = 32767; // -32,768 ~ 32,767 까지 사용가능
        int i = 21474; // 약 20억 정도 사용 가능
        long l = 123871299812379821L;

        // 실수
        float f = 10.2f; // 표현 길이와 정밀도가 낮다. 실수형은 double을 사용
        double d = 10.2; // 실수사용할려면 이걸 사용하자!! 정밀도가 훨씬 높음

    }
}
