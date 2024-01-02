package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    /* 합계와 평균

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 사용자가 입력받을 숫자의 개수를 지정함
        System.out.print("입력 받을 숫자의 개수를 입력하세요:");
        int count = scanner.nextInt();

        // 변수안에 배열 개수를 초기화
        int[] numbers = new int[count];
        int sum = 0; // 더할값
        double average; // 평균값

        System.out.println(count + "개의 정수를 입력하세요:");
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }

        average = (double) sum / count;
        System.out.println("입력한 정수의 합계: " + sum);
        System.out.println("입력한 정수의 평균: " + average);
    }
}
