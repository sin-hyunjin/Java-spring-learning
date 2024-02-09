package com.helloshop.order;

import com.helloshop.product.Product;
import com.helloshop.user.User;

public class Order {
    User user;
    Product product;

    // public를 붙여야 다른 패키지에서 오더를 호출할수 있다
    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
