package com.ecommerceAPI.apiproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceAPI.apiproject.entity.Cart;
import com.ecommerceAPI.apiproject.entity.Order;
import com.ecommerceAPI.apiproject.entity.OrderStatus;
import com.ecommerceAPI.apiproject.exception.CartNotFoundException;
import com.ecommerceAPI.apiproject.exception.OrderNotFoundException;
import com.ecommerceAPI.apiproject.repository.CartRepository;
import com.ecommerceAPI.apiproject.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    // Create
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get One
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    // Get All
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update
    @Override
    public Order updateOrder(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        orderToUpdate.setProductDetails(order.getProductDetails());
        orderToUpdate.setQuantity(order.getQuantity());
        orderToUpdate.setTotalPrice(order.getTotalPrice());
        orderToUpdate.setOrderStatus(order.getOrderStatus());
        return orderRepository.save(orderToUpdate);
    }

    // Delete
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order processOrderFromCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
        Order newOrder = new Order();

        newOrder.setProductDetails("Multiple Products");
        newOrder.setQuantity(cart.getQuantity());
        newOrder.setTotalPrice((double) cart.getAmount());
        newOrder.setOrderStatus(OrderStatus.PLACED);
        newOrder.setCustomer(cart.getCustomer());

        Order savedOrder = orderRepository.save(newOrder);
        cartRepository.deleteById(cartId);
        return savedOrder;
    }

}