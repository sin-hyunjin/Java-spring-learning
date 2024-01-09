package scope;

public class Scope3_2 {

    public static void main(String[] args) {
        int m = 10;
        if (m > 0) {
            // temp는 if문 안의 로컬변수 안에서만 사용가능하다.
            int temp = m * 2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
