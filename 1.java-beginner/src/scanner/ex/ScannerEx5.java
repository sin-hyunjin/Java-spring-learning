package scanner.ex;

import java.util.Scanner;

public class ScannerEx5 {
    /* 두개 사이 숫자를 출력하는 프로그램
        - 사용자에게 숫자를 입력받음 num1 , num2
        - 만약 첫 번째 숫자 num1이 두번째 숫자 num2보다 크다면, 두숫자를 겨환
        - num1부터, num2까지의 모든 숫자를 출력
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요:");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요:");
        int num2 = scanner.nextInt();

        // num1이 num2보다 큰 경우, 두 숫자를 교환합니다.
        if (num1 > num2) {
            int temp = num1; // 임시변수에 num1값을 넣어주기
            num1 = num2;
            num2 = temp;
        }

        System.out.print("두 숫자 사이의 모든 정수:");
        for (int i = num1; i <= num2; i++) {
            System.out.print(i);

            // 마지막 쉼표를 없애기 위해 i가 마지막값이 아니면 쉼표를 출력 x
            if (i != num2) {
                System.out.print(",");
            }
        }
    }
}
