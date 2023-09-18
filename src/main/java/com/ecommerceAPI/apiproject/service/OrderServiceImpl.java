package com.ecommerceAPI.apiproject.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ecommerceAPI.apiproject.entity.Cart;
import com.ecommerceAPI.apiproject.entity.Order;
import com.ecommerceAPI.apiproject.repository.OrderRepository;
import com.ecommerceAPI.apiproject.exceptions.OrderNotFoundException;

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
        // Retrieve order from DB
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        // Update the fields
        orderToUpdate.setProductName(order.getProductName());
        orderToUpdate.setQuantity(order.getQuantity());
        orderToUpdate.setTotalPrice(order.getTotalPrice());
        // Add other fields here as needed
        return orderRepository.save(orderToUpdate);
    }

    // Delete
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order processOrderFromCart(Long cartId) {
        // 1. Fetch cart by ID
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

        // 2. Create a new Order object and populate it with items from the cart
        Order newOrder = new Order();

        double totalOrderPrice = 0.0;
        List<CartItem> cartItemsList = new ArrayList<>();

        for (CartItem cartItem : cart.getCartItems()) {
            double itemTotalPrice = cartItem.getQuantity() * cartItem.getUnitPrice();
            totalOrderPrice += itemTotalPrice;

            // your Order
            CartItem orderItem = convertCartItemToOrderItem(cartItem);
            cartItemsList.add(orderItem);
        }

        newOrder.setCartItems(cartItemsList);
        newOrder.setTotalPrice(totalOrderPrice);
        newOrder.setOrderStatus(OrderStatus.PLACED);

        // 3. Save the order
        Order savedOrder = orderRepository.save(newOrder);

        // 4. Clear the cart items or delete the cart
        cartRepository.deleteById(cartId);

        // 5. Return the saved order
        return savedOrder;
    }

    private CartItem convertCartItemToOrderItem(CartItem cartItem) {

        return cartItem;
    }

}