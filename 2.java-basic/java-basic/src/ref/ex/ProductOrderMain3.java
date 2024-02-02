package ref.ex;

import java.util.Scanner;

/**
 앞서 만든 상품 주문 시스템을 사용자 입력을 받도록 개선해보자.
 */
public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력할 주문의 개수를 입력하세요 : ");
        int n = scanner.nextInt(); // 1 enter를 치면 \n는 남아버리는 문제가생김
        scanner.nextLine();

        ProdectOrder[] orders = new ProdectOrder[n];
        for(int i = 0; i < orders.length; i++) {
            System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드

            orders[i] = createOrder(productName, price, quantity);
        }


        printOrders(orders);
        int totalAmount = getTotalAmount(orders); // cmd + option + v
        System.out.println("총 결제 금액: " + totalAmount);
    }

    static ProdectOrder createOrder(String productName, int price, int quantity) {
        ProdectOrder order = new ProdectOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProdectOrder[] orders) {
        for (ProdectOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " +
                    order.price + ", 수량: " + order.quantity);
        }
    }
    static int getTotalAmount(ProdectOrder[] orders) {
        int tatalAmount = 0;
        for (ProdectOrder order : orders) {
            tatalAmount += order.price + order.quantity;
        }
        return tatalAmount;
    }
}
