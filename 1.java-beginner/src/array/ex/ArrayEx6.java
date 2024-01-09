package array.ex;

import java.util.Scanner;

public class ArrayEx6 {
    /*
    가장 작은 수, 큰 수 찾기 프로그램
    사용자로부터 입력 받은 숫자 중에서 가장 작은 수와 큰 수를 찾아 출력하는 프로그램입니다.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 받을 숫자의 개수를 입력하세요:");

        // 사용자로부터 숫자의 개수를 입력 받음
        int n = scanner.nextInt();

        // 입력 받은 숫자의 개수로 배열 생성
        int[] numbers = new int[n];
        int minNumber, maxNumber;

        // 사용자로부터 n개의 정수를 입력 받음
        System.out.println(n + "개의 정수를 입력하세요:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 배열에서 가장 작은 수와 큰 수를 찾음
        minNumber = maxNumber = numbers[0];
        for (int i = 1; i < n; i++) {

            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        // 결과 출력
        System.out.println("가장 작은 정수: " + minNumber);
        System.out.println("가장 큰 정수: " + maxNumber);
    }
}
