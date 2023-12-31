package loop;

public class Continue1 {

    public static void main(String[] args) {
        int i = 1;

        while(i <= 5) {
            // i == 3인 경우 i를 하나 증가하고 i를 출려하지 않고 바로 while(i <=5) 조건식으로 이동한다
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
