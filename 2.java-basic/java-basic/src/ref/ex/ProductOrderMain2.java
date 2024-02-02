package ref.ex;

/**
 * 다음으로 ref.ex.ProductOrderMain2 클래스 안에 main() 메서드를 포함하여, 여러 상품의 주문 정보를 배열
 * 로 관리하고, 그 정보들을 출력하고, 최종 결제 금액을 계산하여 출력하자. 이 클래스에서는 다음과 같은 메서드를 포함
 * 해야 합니다:
 * static ProductOrder createOrder(String productName, int price, int quantity)
 * ProductOrder 를 생성하고 매개변수로 초기값을 설정합니다. 마지막으로 생성한 ProductOrder 를
 * 반환합니다.
 * static void printOrders(ProductOrder[] orders)
 * 배열을 받아서 배열에 들어있는 전체 ProductOrder 의 상품명, 가격, 수량을 출력합니다.
 * static int getTotalAmount(ProductOrder[] orders)
 * 배열을 받아서 배열에 들어있는 전체 ProductOrder 의 총 결제 금액을 계산하고, 계산 결과를 반환합니
 * 다.
 */
public class ProductOrderMain2 {
    public static void main(String[] args) {
        ProdectOrder[] orders = new ProdectOrder[3];


        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);

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
