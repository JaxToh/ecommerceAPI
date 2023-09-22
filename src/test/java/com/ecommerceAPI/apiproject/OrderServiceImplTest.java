package com.ecommerceAPI.apiproject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerceAPI.apiproject.entity.Cart;
import com.ecommerceAPI.apiproject.entity.Order;
import com.ecommerceAPI.apiproject.exceptions.CartNotFoundException;
import com.ecommerceAPI.apiproject.repository.CartRepository;
import com.ecommerceAPI.apiproject.repository.OrderRepository;
import com.ecommerceAPI.apiproject.repository.ProductRepository;
import com.ecommerceAPI.apiproject.service.OrderServiceImpl;

@SpringBootTest
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void processOrderFromCartTest() {

        Long cartId = 1L;
        Cart cart = mock(Cart.class);
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));

        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order processedOrder = orderService.processOrderFromCart(cartId);

        assertEquals(order, processedOrder, "The processed order should be the same as the mocked order");
        verify(cartRepository, times(1)).deleteById(cartId);

    }

    @Test
    void processOrderFromCartNotFoundTest() {
        Long cartId = 1L;
        when(cartRepository.findById(cartId)).thenReturn(Optional.empty());

        assertThrows(CartNotFoundException.class, () -> orderService.processOrderFromCart(cartId));
    }
}
