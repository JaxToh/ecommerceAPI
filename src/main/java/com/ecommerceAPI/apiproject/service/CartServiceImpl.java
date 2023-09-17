package com.ecommerceAPI.apiproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.ecommerceAPI.apiproject.entity.Cart;
import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.exceptions.CartNotFoundException;
import com.ecommerceAPI.apiproject.exceptions.InsufficientQuantityException;
import com.ecommerceAPI.apiproject.repository.CartRepository;
import com.ecommerceAPI.apiproject.repository.ProductRepository;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    // Create
    @Override
    public Cart createCart(Cart cart) {
        // return cart
        return cartRepository.save(cart);
    }

    // Get One
    @Override
    public Cart getCartById(Long id) {

        return cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
    }

    // Get All
    @Override
    public List<Cart> getAllCart() {
        List<Cart> allCart = cartRepository.findAll();
        return allCart;
    }

    // Update
    @Override
    public Cart updateCart(Long id, Cart cart) {
        // load cart from DB
        Cart cartToUpdate = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));

        // Load product from DB
        Product product = ProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        int requestedQuantity = cart.getQuantity();
        int availableQuantity = product.getQuantity();

        if (requestedQuantity <= availableQuantity) {
            // Update the cart with the new values
            cartToUpdate.setQuantity(requestedQuantity);
            cartToUpdate.setAmount(cart.getAmount());
            cartToUpdate.setProducts(cart.getProducts());
    
            // Decrease the available quantity of the product
            // product.setQuantity(availableQuantity - requestedQuantity);
            // productRepository.save(product);
    
            // Save the updated cart to the database
            return cartRepository.save(cartToUpdate);
        } else {
            // Throw an error indicating insufficient quantity
            throw new InsufficientQuantityException("Insufficient quantity");
        }

    }

    // Delete
    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

}
