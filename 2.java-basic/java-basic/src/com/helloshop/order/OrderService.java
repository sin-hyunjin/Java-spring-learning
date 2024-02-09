package com.helloshop.order;

import com.helloshop.product.Product;
import com.helloshop.user.User;

/** 주문하는 서비스 */
public class OrderService {
    public void order() {
        User user = new User(); //회원
        Product product = new Product(); //상품
        Order order = new Order(user, product); //주문

    }
}
