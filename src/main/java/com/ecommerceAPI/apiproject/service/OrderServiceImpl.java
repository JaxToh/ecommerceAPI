package com.ecommerceAPI.apiproject.service;

import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ecommerceAPI.apiproject.entity.Cart;
import com.ecommerceAPI.apiproject.entity.Order;
import com.ecommerceAPI.apiproject.entity.OrderStatus;
import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.repository.CartRepository;
import com.ecommerceAPI.apiproject.repository.OrderRepository;
import com.ecommerceAPI.apiproject.repository.ProductRepository;
import com.ecommerceAPI.apiproject.exceptions.CartNotFoundException;
import com.ecommerceAPI.apiproject.exceptions.OrderNotFoundException;
import com.ecommerceAPI.apiproject.exceptions.ProductNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    // Create
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get One
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));// lamda expression
    }

    // Get All
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update
    @Transactional
    @Override
    public Order updateOrder(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        // Check if the order status is set to cancel
        if (OrderStatus.CANCELLED.equals(order.getOrderStatus())) {
            orderToUpdate.setOrderStatus(OrderStatus.CANCELLED);

            // Assuming you have a field productId in your Order entity to map an order to a
            // product
            Product product = productRepository.findById(orderToUpdate.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(orderToUpdate.getProductId()));

            // Return the product quantity back to the product stock
            product.setQuantity(product.getQuantity() + orderToUpdate.getQuantity());
            productRepository.save(product); // Save the updated product

        } else {
            // If the order is not cancelled, just update the order details

            // If order quantity is modified, adjust the product stock accordingly
            if (!orderToUpdate.getQuantity().equals(order.getQuantity())) {
                Product product = productRepository.findById(orderToUpdate.getProductId())
                        .orElseThrow(() -> new ProductNotFoundException(orderToUpdate.getProductId()));

                // Adjust the product quantity.
                // Assuming that the order quantity cannot exceed the available product
                // quantity.
                int quantityDifference = orderToUpdate.getQuantity() - order.getQuantity();
                product.setQuantity(product.getQuantity() + quantityDifference);

                productRepository.save(product); // Save the updated product
            }

            orderToUpdate.setProductDetails(order.getProductDetails());
            orderToUpdate.setQuantity(order.getQuantity());
            orderToUpdate.setTotalPrice(order.getTotalPrice());
            orderToUpdate.setOrderStatus(order.getOrderStatus());
        }

        return orderRepository.save(orderToUpdate);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id); // find the correct product, set update the product,
                                        // orderToUpdate.setOrderStatus(order.getOrderStatus(cancelled));
    }

    @Transactional
    @Override
    public Order processOrderFromCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
        Order newOrder = new Order();

        // assuming cart.getProducts() returns a List<Product> representing the products
        // in the cart
        List<Product> products = cart.getProducts();
        for (Product product : products) {
            int availableQuantity = product.getQuantity();
            int orderedQuantity = cart.getQuantity(); // replace with the actual quantity ordered for this product

            if (orderedQuantity > availableQuantity) {
                throw new RuntimeException("Insufficient quantity for product: " + product.getId());
            }

            product.setQuantity(availableQuantity - orderedQuantity);
            productRepository.save(product);
        }

        // Set Product Details, consider using a meaningful representation of products
        // in the order
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