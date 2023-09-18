package com.ecommerceAPI.apiproject.service;

import java.util.List;

import com.ecommerceAPI.apiproject.entity.Order;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

    Order processOrderFromCart(Long cartId);
}
