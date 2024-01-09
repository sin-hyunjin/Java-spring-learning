package scanner;

import java.util.Scanner;

public class Scanner3 {

    public static void main(String[] args) {
        // System.in 사용자에게 입력받을 곳
        Scanner scanner = new Scanner(System.in);
        // 첫번째 숫자입력 하는 곳
        System.out.print("첫 번째 숫자를 입력하세요:");
        int num1 = scanner.nextInt();
        // 두번쨰 숫자 입력 하는 곳
        System.out.print("두 번째 숫자를 입력하세요:");
        int num2 = scanner.nextInt();

        // 조건문으로 더 큰 숫자 출력하는 로직
        if (num1 > num2) {
            System.out.println("더 큰 숫자: " + num1);
        } else if (num2 > num1){
            System.out.println("더 큰 숫자: " + num2);
        } else {
            System.out.println("두 숫자는 같습니다.");
        }
    }
}
