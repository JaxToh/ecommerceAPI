package com.ecommerceAPI.apiproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceAPI.apiproject.entity.Order;
import com.ecommerceAPI.apiproject.entity.User;
import com.ecommerceAPI.apiproject.exception.OrderNotFoundException;
import com.ecommerceAPI.apiproject.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

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
        return orderRepository.save(orderToUpdate);
    }

    // Delete
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // @Override
    // public List<Order> getOrdersOfUser(User user) {
    //     return orderRepository.findByUser(user);
    // }

}