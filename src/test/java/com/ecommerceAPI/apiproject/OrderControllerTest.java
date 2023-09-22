package com.ecommerceAPI.apiproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ecommerceAPI.apiproject.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Get order by Id")
    @Test
    public void getOrderByIdTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/orders/1");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @DisplayName("Get All Orders")
    @Test
    public void getAllOrdersTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/orders");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @DisplayName("Valid Order Creation")
    @Test
    public void validOrderCreationTest() throws Exception {

        Order order = new Order();
        String newOrderAsJSON = objectMapper.writeValueAsString(order);
        RequestBuilder request = MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newOrderAsJSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber());

    }

    @DisplayName("Invalid Order Creation")
    @Test
    public void invalidOrderCreationTest() throws Exception {

        Order invalidOrder = new Order();

        String invalidOrderAsJSON = objectMapper.writeValueAsString(invalidOrder);

        RequestBuilder request = MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidOrderAsJSON);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
