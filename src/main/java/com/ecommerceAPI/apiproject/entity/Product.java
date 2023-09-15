package com.ecommerceAPI.apiproject.entity;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter



@Entity
@Table(name="product")
public class Product {

//define fields
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long productId;

@Column(name="product_name")
private String productName;

@Column(name="product_category")
private String productCat;

@Column(name="description")
private String productDesc;

@Column(name="price")
private Double productPrice;

//define constructors
public Product(){

}

public Product(String productName, String productCat, String productDesc, Double productPrice) {
    this.productName = productName;
    this.productCat = productCat;
    this.productDesc = productDesc;
    this.productPrice = productPrice;
}
//define getters and setters

//define toString() methods
@Override
public String toString() {
    return "Product [productId=" + productId + ", productName=" + productName + ", productCat=" + productCat
            + ", productDesc=" + productDesc + ", productPrice=" + productPrice + "]";
}

public void add(Product product) {
}






}