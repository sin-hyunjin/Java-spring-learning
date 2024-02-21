package hello.core.order;

public interface OrderService {

    /** 회원주문
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);


}
