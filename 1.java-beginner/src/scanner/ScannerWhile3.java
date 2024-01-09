package scanner;

import java.util.Scanner;

public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /* 사용자 입력을 받아 그합계를 계산하는 프로그램
        - 사용자는 한개의 정수를 입력할 수 있음
        - 사용자가 0을 입력하면 프로그랴ㅐㅁ은 종료된다
        - 프로그램이 종료될 때 까지 사용자가 입력한 모든 정수의 합을 출력해야 한다 .
         */
        int sum = 0;

        while (true) {
            System.out.print("정수를 입력하세요 (0을 입력하면 종료):");
            int number = input.nextInt();
            // 0이면 프로그램을 빠져나감
            if (number == 0) {
                break;
            }
            sum += number;
        }
        System.out.println("입력한 모든 정수의 합: " + sum);
    }
}
