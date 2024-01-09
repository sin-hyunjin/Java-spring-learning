package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 상품 가격 계산
            사용자로부터 상품의 가격과 수량을 입력 받고, 총 비용을 출력하는 프로그램
            - 가격과 수량을 입력받은 후에는 이들의 곱을 출력하여야함
            - -1을 입력하여 입력을 종료
         */
        while (true) {
            System.out.print("상품의 가격을 입력하세요 (-1을 입력하면 종료): ");
            int price = input.nextInt();

            if (price == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("구매하려는 수량을 입력하세요: ");
            int quantity = input.nextInt();

            int totalCost = price * quantity;
            System.out.println("총 비용: " + totalCost);
        }
    }
}
