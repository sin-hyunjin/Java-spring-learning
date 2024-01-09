package array.ex;

import java.util.Scanner;

public class ArrayEx2 {
    /* 배열의 입력과 출력
        -사용자에게 5개의 정수를 입력 받고, 입력 순서대로 출력
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("5개의 정수를 입력하세요:");
        for (int i = 0; i < numbers.length; i++) {
            // 사용자가 입력한 숫자를 배열인덱스에 대입해야한다.
            numbers[i] = scanner.nextInt();
        }

        System.out.println("출력");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
