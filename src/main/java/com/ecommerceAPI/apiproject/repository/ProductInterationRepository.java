package com.ecommerceAPI.apiproject.repository;
import com.ecommerceAPI.apiproject.entity.ProductInteraction;
import com.ecommerceAPI.apiproject.repository.ProductInterationRepository;


public class ProductInterationRepository extends JpaRepository<ProductInterationRepository, Long> {

    public static ProductInteraction save(ProductInteraction interactionToUpdate) {
        return null;
    }

    public static Object findById(Long id) {
        return null;
    }

    public static void deleteById(Long id) {
    }

}